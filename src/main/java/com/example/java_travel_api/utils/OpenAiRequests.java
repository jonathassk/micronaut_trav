package com.example.java_travel_api.utils;

import com.example.java_travel_api.config.OpenAiConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OpenAiRequests {

    private final OpenAiConfig openai;

    @Value("${OPEN_AI_AUTHORIZATION}")
    private String OPEN_AI_AUTHORIZATION;

    public OpenAiRequests(OpenAiConfig openai) {
        this.openai = openai;
    }

    public void sendRequestOpenAi(String text) throws JsonProcessingException {
        try (CloseableHttpClient httpClient = openai.httpClient()) {
            ObjectMapper objectMapper = new ObjectMapper();
            HttpPost httpPost = configMessageRequest(text, objectMapper);

            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println("response body" + responseBody);
            if (statusCode == 200) {
                Map<String, Object> responseMap = objectMapper.readValue(responseBody, Map.class);
                List<Map<String, Object>> choices = (List<Map<String, Object>>) responseMap.get("choices");
                if (choices != null && !choices.isEmpty()) {
                    String gptResponse = (String) choices.get(0).get("text");
                    System.out.println("Resposta GPT-4: " + gptResponse);
                }
            } else {
                System.out.println("Erro: " + statusCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpPost configMessageRequest(String content, ObjectMapper objectMapper) throws JsonProcessingException {
        HttpPost httpPost = openai.createHttpPost();

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4o-mini");

        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", "ola, bom dia, apenas um teste");
        messages.add(message);

        requestBody.put("messages", messages);


        String jsonBody = objectMapper.writeValueAsString(requestBody);

        httpPost.setEntity(new StringEntity(jsonBody, "UTF-8"));
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", OPEN_AI_AUTHORIZATION);
        return httpPost;
    }
}
