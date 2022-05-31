package ru.kuranov.restexchange.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuranov.restexchange.dto.ResponseCurrencyDto;

@FeignClient(value = "currencyFeign", url = "https://openexchangerates.org/api/")
public interface CurrencyFeign {

    @RequestMapping(path = "latest.json?app_id=b273981d1fee4f0d9615d30265fa1a45&base=USD")
    ResponseCurrencyDto getLatestCurrency();

    @RequestMapping(path = "/historical/2012-07-10.json?app_id=b273981d1fee4f0d9615d30265fa1a45")
    ResponseCurrencyDto getHistoricalCurrency();

//    @RequestMapping(path = "https://api.giphy.com/v1/gifs/search?api_key=9UJyzSaLCDYv26sv1QbsVr4M4L33qzpE&q=rich&limit=3")
//    ResponseEntity<?> getRich();




    //https://openexchangerates.org/api/historical/2012-07-10.json?app_id=YOUR_APP_ID


    //OPENEXCHANGE
    //b273981d1fee4f0d9615d30265fa1a45


    //GIPHY
    //9UJyzSaLCDYv26sv1QbsVr4M4L33qzpE
}
