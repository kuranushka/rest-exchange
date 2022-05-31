package ru.kuranov.restexchange.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "gifFeign", url = "https://api.giphy.com/v1/gifs/search?api_key=9UJyzSaLCDYv26sv1QbsVr4M4L33qzpE&q=rich&limit=10")
public interface GifFeign {

    @RequestMapping(path = "")
    ResponseEntity<?> getRich();

    @RequestMapping
    ResponseEntity<?> getBroke();
}
