package com.congestion.tax.calculator.controller;

import com.congestion.tax.calculator.dto.CongestionTaxCalculatorRequest;
import com.congestion.tax.calculator.dto.CongestionTaxCalculatorResponse;
import com.congestion.tax.calculator.service.CongestionTaxCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/congestionTax")
public class CongestionTaxCalculatorController {
    @Autowired
    CongestionTaxCalculatorService congestionTaxCalculatorService;
    @PostMapping("/calculatedTax")
    public ResponseEntity<CongestionTaxCalculatorResponse> taxCalculate(@RequestBody CongestionTaxCalculatorRequest request) {

        CongestionTaxCalculatorResponse response;

        try {
            int tax = congestionTaxCalculatorService.getTax(request.getVehicle_type(), request.getDates());
            response = new CongestionTaxCalculatorResponse(null, tax,
                    "Tax calculated successfully, Vehicle :" + request.getVehicle_type().name() + " Amount : " + tax);
            return new ResponseEntity<CongestionTaxCalculatorResponse>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new CongestionTaxCalculatorResponse(e.getLocalizedMessage(), 0,
                    "Tax calculation failed.");
            return new ResponseEntity<CongestionTaxCalculatorResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
