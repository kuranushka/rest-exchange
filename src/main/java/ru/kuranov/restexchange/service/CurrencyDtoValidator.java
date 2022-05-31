package ru.kuranov.restexchange.service;

import org.springframework.stereotype.Service;
import ru.kuranov.restexchange.dto.RequestCurrencyDto;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CurrencyDtoValidator {
    public void validate(RequestCurrencyDto requestCurrencyDto) {
        Pattern pattern = Pattern.compile("^\\w+$");
        Matcher matcher = pattern.matcher(requestCurrencyDto.getCurrency().toUpperCase(Locale.ROOT));
        if (matcher.find()) {
            return;
        } else {
            throw new RuntimeException(efg);
        }
    }
}
