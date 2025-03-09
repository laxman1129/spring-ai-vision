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
public class TerminalVisionTask {
    private final ChatModel chatModel;
    @Value("classpath:/files/screen.png")
    private Resource terminalImageResource;

    public void process() {
        System.out.println("TerminalVisionTask.process");

        var userMessage = new UserMessage("""
                You are expert at reading the terminal window of computer shell.
                read the text which can be logs/instructions/code etc. as is in the image.
                Do not provide explanation or summary. Just print the Number plate as is in the image.
                """,
                List.of(new Media(MimeTypeUtils.IMAGE_PNG, terminalImageResource)));

        String response = chatModel.call(userMessage);
        System.out.printf("TerminalVisionTask.process: %s%n", response);

    }

}
