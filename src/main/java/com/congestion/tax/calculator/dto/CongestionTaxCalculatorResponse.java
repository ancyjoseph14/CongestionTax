package com.congestion.tax.calculator.dto;

import java.sql.Timestamp;

public class CongestionTaxCalculatorResponse {
    private String error;
    private int tax;
    private String message;

    public CongestionTaxCalculatorResponse(String error, int tax, String message) {
        super();
        this.error = error;
        this.tax = tax;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public int getTax() {
        return tax;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }
}
