package ru.kuranov.restexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RestExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestExchangeApplication.class, args);
	}

}
