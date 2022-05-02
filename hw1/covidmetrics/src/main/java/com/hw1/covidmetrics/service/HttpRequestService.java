package com.hw1.covidmetrics.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestService {
    
    private static final String URL = "https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api";
    private static final String HOST = "vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com";
    private static final String KEY = "43f0a578a1mshfbfd1d8a8523bd6p1fa659jsnf90331a3ab0b";

    public HttpRequestService() {}

    public String doHttpGet(String endpoint) throws IOException, InterruptedException {
        
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create(URL + endpoint))
		.header("X-RapidAPI-Host", HOST)
		.header("X-RapidAPI-Key", KEY)
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
