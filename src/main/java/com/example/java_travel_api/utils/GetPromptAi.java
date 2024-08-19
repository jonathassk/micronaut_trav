package com.example.java_travel_api.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

@Component
public class GetPromptAi {

    public String getPromptText(Queue<String> infoTravel) {

        String filePath = "src/main/resources/static/prompt.txt";
        StringBuilder sBuilder = new StringBuilder();
        try {
            String prompt = new String(Files.readAllBytes(Paths.get(filePath)));
            sBuilder.append(prompt);
            Stream.of("quantPerson", "city", "dayBegin", "dayEnd", "value").forEach(item -> {
                int index = sBuilder.indexOf(item);
                sBuilder.replace(index, index + item.length(), Objects.requireNonNull(infoTravel.poll()));
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return sBuilder.toString();
    }
}
