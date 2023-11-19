package com.congestion.tax.calculator.service;

import com.congestion.tax.calculator.domain.TollFreeVehicle;
import com.congestion.tax.calculator.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class CongestionTaxCalculatorService {
    @Autowired
    TollFreeVehicle tollFreeVehicle;

    public int getTax(Vehicle vehicle, Date[] dates) {

        int totalFee = 0;

        for (int i = 0; i < dates.length; i++) {
            int tollFee = 0;
            if (i == 0 || dateDiff(dates[i - 1], dates[i])) {
                tollFee = getTollFee(dates[i], vehicle.name());
                totalFee += tollFee;
            }
        }

        if (totalFee > 60)
            totalFee = 60;
        return totalFee;
    }
    private boolean dateDiff(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.MILLISECONDS.toMinutes(diff) > 60;
    }

    private boolean IsTollFreeVehicle(String vehicleType) {
        if (vehicleType == null)
            return false;
        return tollFreeVehicle.getVehicles().contains(vehicleType);
    }

    public int getTollFee(Date date, String vehicle)
    {
        if (IsTollFreeDate(date) || IsTollFreeVehicle(vehicle)) return 0;

        int hour = date.getHours();
        int minute = date.getMinutes();

        if (hour == 6 && minute >= 0 && minute <= 29) return 8;
        else if (hour == 6 && minute >= 30 && minute <= 59) return 13;
        else if (hour == 7 && minute >= 0 && minute <= 59) return 18;
        else if (hour == 8 && minute >= 0 && minute <= 29) return 13;
        else if (hour >= 8 && hour <= 14 && minute >= 30 && minute <= 59) return 8;
        else if (hour == 15 && minute >= 0 && minute <= 29) return 13;
        else if (hour == 15 && minute >= 0 || hour == 16 && minute <= 59) return 18;
        else if (hour == 17 && minute >= 0 && minute <= 59) return 13;
        else if (hour == 18 && minute >= 0 && minute <= 29) return 8;
        else return 0;
    }

    private Boolean IsTollFreeDate(Date date)
    {
        int year = date.getYear();
        int month = date.getMonth() + 1;
        int day = date.getDay() + 1;
        int dayOfMonth = date.getDate();

        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) return true;

        if (year == 2013)
        {
            if ((month == 1 && dayOfMonth == 1) ||
                    (month == 3 && (dayOfMonth == 28 || dayOfMonth == 29)) ||
                    (month == 4 && (dayOfMonth == 1 || dayOfMonth == 30)) ||
                    (month == 5 && (dayOfMonth == 1 || dayOfMonth == 8 || dayOfMonth == 9)) ||
                    (month == 6 && (dayOfMonth == 5 || dayOfMonth == 6 || dayOfMonth == 21)) ||
                    (month == 7) ||
                    (month == 11 && dayOfMonth == 1) ||
                    (month == 12 && (dayOfMonth == 24 || dayOfMonth == 25 || dayOfMonth == 26 || dayOfMonth == 31)))
            {
                return true;
            }
        }
        return false;
    }
}
