package com.mock.mock.externalapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final String API_URL = "http://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=";

    public String getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(API_URL + city, String.class);
        return result;
    }
}
