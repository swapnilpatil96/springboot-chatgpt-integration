package com.example.chaptgpt.chatgpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private String role;     // "user", "system", or "assistant"
    private String content;  // Message text
}

