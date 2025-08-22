package com.example.chaptgpt.chatgpt.dto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChatCompletionRequest {
    private String model;
    private List<ChatMessage> messages;
    private Double temperature;
    private Integer max_tokens;
}