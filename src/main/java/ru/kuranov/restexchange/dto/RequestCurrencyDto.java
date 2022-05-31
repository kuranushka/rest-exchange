package ru.kuranov.restexchange.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestCurrencyDto {

    private String currency;
}
