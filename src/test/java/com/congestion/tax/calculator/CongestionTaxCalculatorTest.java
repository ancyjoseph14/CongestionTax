package com.congestion.tax.calculator;

import com.congestion.tax.calculator.dto.CongestionTaxCalculatorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CongestionTaxCalculatorTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    @Test
    public void testTaxExemptvehicles() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("{\"vehicle_type\": \"Emergency\",\"dates\": [\"2013-01-07 10:00:00\"]}", headers);
        ResponseEntity<CongestionTaxCalculatorResponse> response = restTemplate
                .postForEntity(new URL("http://localhost:" + port + "/congestionTax/calculatedTax").toString(), request, CongestionTaxCalculatorResponse.class);
        assertEquals(0, response.getBody().getTax());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
