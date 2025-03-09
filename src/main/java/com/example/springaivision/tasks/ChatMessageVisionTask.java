package com.example.springaivision.tasks;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.model.Media;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChatMessageVisionTask {
    private final ChatModel chatModel;

    @Value("classpath:/files/messages.png")
    private Resource messagesImageResource;

    public void process() {
        System.out.println("ChatMessageVisionTask.process");

        var userMessage = new UserMessage("""
                You are good text chat reader. read the chat messages from the image and print the text as is in the image.
                Do not provide explanation or summary. Just print the text as is in the image.
                """,
                List.of(new Media(MimeTypeUtils.IMAGE_PNG, messagesImageResource)));

        String response = chatModel.call(userMessage);
        System.out.printf("ChatMessageVisionTask.process: %s%n", response);

    }

}
