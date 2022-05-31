package ru.kuranov.restexchange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuranov.restexchange.dto.RequestCurrencyDto;
import ru.kuranov.restexchange.service.CurrencyDtoValidator;
import ru.kuranov.restexchange.service.Handler;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyDtoValidator validator;
    private final Handler handler;

    //TODO вынести параметры
    // настроить Feign, в том числе  Retryer
    // развесить всё в Cloud????
    // errors exceptions
    // соорудить Docker
    // запустить Swagger
    // покрыть всё тестами
    // раскидать методы
    // написать комментарии


    @PostMapping
    public ResponseEntity<?> getGif(@RequestBody RequestCurrencyDto requestCurrencyDto) {
        validator.validate(requestCurrencyDto);
        return new ResponseEntity<>(handler.getGif(requestCurrencyDto), HttpStatus.OK);
    }
}
