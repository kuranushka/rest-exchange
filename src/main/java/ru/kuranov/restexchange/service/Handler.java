package ru.kuranov.restexchange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.kuranov.restexchange.dto.GifDto;
import ru.kuranov.restexchange.dto.ResponseCurrencyDto;
import ru.kuranov.restexchange.dto.RequestCurrencyDto;
import ru.kuranov.restexchange.dto.UrlDto;
import ru.kuranov.restexchange.feign.CurrencyFeign;
import ru.kuranov.restexchange.feign.GifFeign;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Handler {

    private final CurrencyFeign currencyFeign;
    private final GifFeign gifFeign;

    public UrlDto getGif(RequestCurrencyDto requestCurrencyDto) {

        ResponseCurrencyDto latestCurrency = currencyFeign.getLatestCurrency();
        ResponseCurrencyDto historicalCurrency = currencyFeign.getHistoricalCurrency();

        boolean isMoreThanYesterday = latestCurrency.getRates()
                .entrySet()
                .stream()
                .filter(latestEntry -> latestEntry.getKey().equals(requestCurrencyDto.getCurrency()))
                .map(latestEntry -> {
                    return historicalCurrency.getRates()
                            .entrySet()
                            .stream()
                            .filter(historicalEntry -> historicalEntry.getKey().equals(requestCurrencyDto.getCurrency()))
                            .map(historicalFilteredCurrency -> latestEntry.getValue().compareTo(historicalFilteredCurrency.getValue()))
                            .map(integer -> integer > 0)
                            .findFirst().orElseThrow();
                })
                .findFirst().orElseThrow();


        ResponseEntity<?> response;
        if (isMoreThanYesterday) {
            response = gifFeign.getRich();
        } else {
            response = gifFeign.getBroke();
        }
        Map<Object, Object> body = (Map<Object, Object>) response.getBody();
        GifDto gifDto = GifDto.builder().gifs((List<Map<String, String>>) body.get("data")).build();



        List<String> urls = gifDto.getGifs().stream()
                .flatMap(stringStringLinkedHashMap -> stringStringLinkedHashMap.entrySet().stream())
                .map(map -> {
                    if (map.getKey().equals("url")) {
                        return map.getValue();
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        Collections.shuffle(urls);
        return UrlDto.builder()
                .url(urls.get(0))
                .build();
    }
}
