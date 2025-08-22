package com.example.chaptgpt.chatgpt.service;

import com.example.chaptgpt.chatgpt.dto.ChatCompletionRequest;
import com.example.chaptgpt.chatgpt.dto.ChatCompletionResponse;
import com.example.chaptgpt.chatgpt.dto.ChatMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ChatGptService {

    @Value("${openapi.api.model}")
    private String model;

    private final RestClient restClient;

    public ChatGptService(@Value("${openapi.api.key}") String apiKey,
                          @Value("${openapi.api.url}") String apiUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public String getChatResponse(String prompt) {
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model(model)
                .messages(List.of(new ChatMessage("user", prompt)))
                .temperature(0.7)
                .max_tokens(100)
                .build();

        ChatCompletionResponse response = restClient.post()
                .body(request)
                .retrieve()
                .body(ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }
}
