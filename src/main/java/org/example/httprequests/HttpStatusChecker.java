package org.example.httprequests;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final String REQUEST_URL = "https://http.cat";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Logger logger = Logger.getLogger(HttpStatusChecker.class);

    public String getStatusImage(int code) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(REQUEST_URL + "/" + code + ".jpg"))
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 404) {
                throw new IOException();
            }
            return response.uri().toString();

        } catch (IOException |InterruptedException e) {
            e.printStackTrace();
            logger.error("File does`t exist");
            throw new RuntimeException(e);
        }

    }


}
