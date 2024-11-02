package com.example.SpringAI.Services.AIServices;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.internal.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Configuration
@Slf4j
public class ConfigLangChain {

    @Value("${ai.model.name}")
    private String MODEL_NAME;
    @Value("${ai.base.url}")
    private String Base_URL;
    @Value("${ai.api.key}")
    private String API_KEY;

    @Bean
    public ChatLanguageModel chatClient(){
        ChatLanguageModel model= OpenAiChatModel.builder()
                .baseUrl(Base_URL)
                .apiKey(API_KEY)
                .modelName(MODEL_NAME)
                .build();
        return  model;
    }

}