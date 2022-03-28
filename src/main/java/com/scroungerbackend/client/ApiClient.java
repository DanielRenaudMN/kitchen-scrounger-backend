package com.scroungerbackend.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiClient {
	@Value("${rapidapi.key.name}")
	private String apiKey;

	@Value("${rapidapi.key.value}")
	private String apiKeyValue;

	private static final String URL = "";

	@Autowired
	RestTemplate restTemplate;

}
