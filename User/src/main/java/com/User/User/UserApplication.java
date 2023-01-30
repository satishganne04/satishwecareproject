package com.User.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.User.User.coachFeignClient")
public class UserApplication {
	/*
	 * @Value("${coach.service.url}") private String coachServiceUrl;
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	/*
	 * @Bean public WebClient webClient () { WebClient webClient
	 * =WebClient.builder() .baseUrl(coachServiceUrl).build();
	 * 
	 * return webClient; }
	 */
}
