package ru.kuranov.restexchange.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GifDto {

    private List<Map<String, String>> gifs;
}
