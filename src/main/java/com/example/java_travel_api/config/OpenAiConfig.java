package com.example.java_travel_api.config;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    @Value("${OPEN_AI_API_KEY}")
    private String OPEN_AI_API_KEY;

    @Value("${OPEN_AI_URL:https://api.openai.com/v1/chat/completions}")
    private String OPEN_AI_URL;

    public CloseableHttpClient httpClient() {
        return HttpClients.createDefault();
    }

    public HttpPost createHttpPost() {
        HttpPost httpPost = new HttpPost(OPEN_AI_URL);
        httpPost.addHeader("Authorization", "Bearer " + OPEN_AI_API_KEY);
        httpPost.addHeader("Content-Type", "application/json");
        return httpPost;
    }
}
