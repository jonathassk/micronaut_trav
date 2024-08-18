package com.example.java_travel_api.utils;

import com.example.java_travel_api.config.OpenAiConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OpenAiRequests {

    private final OpenAiConfig openai;

    public OpenAiRequests(OpenAiConfig openai) {
        this.openai = openai;
    }

    public void sendRequestOpenAi(String text) throws JsonProcessingException {

        CloseableHttpClient httpClient = openai.httpClient();
        HttpPost httpPost = openai.createHttpPost();

        // Configuração do corpo da requisição
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4o-mini");

        // Cria uma lista de mensagens
        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", "ola, bom dia, apenas um teste");
        messages.add(message);

        requestBody.put("messages", messages);

        // Converte o corpo da requisição para JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(requestBody);

        // Configura o corpo da requisição no HttpPost
        httpPost.setEntity(new StringEntity(jsonBody, "UTF-8"));
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer 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");  // Substitua YOUR_API_KEY pela sua chave



        // Executa a requisição e processa a resposta
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println("response body" + responseBody);
            if (statusCode == 200) {
                System.out.println("Response: " + responseBody);

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
}
