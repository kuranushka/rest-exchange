package ru.kuranov.restexchange.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResponseCurrencyDto {

    /**
     * "disclaimer": "Usage subject to terms: https://openexchangerates.org/terms",
     * "license": "https://openexchangerates.org/license",
     * "timestamp": 1654023600,
     * "base": "USD",
     * "rates": {
     * "AED": 3.6731,
     * "AFN": 88.999995,
     */

    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String, Double> rates;
}
