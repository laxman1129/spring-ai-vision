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
public class WebsiteVisionTask {
    private final ChatModel chatModel;
    @Value("classpath:/files/website.png")
    private Resource websiteImageResource;

    public void process() {
        System.out.println("WebsiteVisionTask.process");

        var userMessage = new UserMessage("Capture and print human-readable text from the image",
                List.of(new Media(MimeTypeUtils.IMAGE_PNG, websiteImageResource)));

        String response = chatModel.call(userMessage);
        System.out.printf("WebsiteVisionTask.process: %s%n", response);

    }

}
