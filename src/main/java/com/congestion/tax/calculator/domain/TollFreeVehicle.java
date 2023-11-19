package com.congestion.tax.calculator.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@ConfigurationProperties(prefix = "toll-free")
@Getter
@Setter
public class TollFreeVehicle {

    private Set<String> vehicles;

}
