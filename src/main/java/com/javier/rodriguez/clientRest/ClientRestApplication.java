package com.javier.rodriguez.clientRest;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRestApplication.class, args);

		getActor(5);
	}
	
	@Bean
	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	public static void getActors() {
	
		
		final String uri= "http://localhost:8080/api/actors";
		RestTemplate restTemplate = getRestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		System.out.println(result);
		
	}
	
	public static void getActor(int id) {
		final String uri="http://localhost:8080/api/actors/{id}";
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id",id);
		RestTemplate restTemplate= getRestTemplate();
		String result=restTemplate.getForObject(uri, String.class, params);
		System.out.println(result);
		
		
	}
	
}
