package com.congestion.tax.calculator.dto;

import com.congestion.tax.calculator.domain.Vehicle;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CongestionTaxCalculatorRequest {
    private Vehicle vehicle_type;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Amsterdam")
    private Date[] dates;

    public Vehicle getVehicle_type() {
        return vehicle_type;
    }

    public Date[] getDates() {
        return dates;
    }

    public void setVehicle_type(Vehicle vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public void setDates(Date[] dates) {
        this.dates = dates;
    }
}
