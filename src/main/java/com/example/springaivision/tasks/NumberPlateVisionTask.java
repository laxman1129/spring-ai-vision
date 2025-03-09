package com.example.springaivision.tasks;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.model.Media;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NumberPlateVisionTask {
    private final ChatModel chatModel;
    @Value("classpath:/files/plates/*")
    private Resource[] platesImageResources;

    public void process() {
        System.out.println("NumberPlateVisionTask.process");

        Arrays.stream(platesImageResources).forEach(e -> {
            System.out.printf("NumberPlateVisionTask.process: %s%n", e.getFilename());
            var userMessage = new UserMessage("""
                You are expert of car number plate reading. read the Number Plate from the image and print the Numberplate only as is in the image.
                Do not provide explanation or summary. Just print the Number plate as is in the image.
                """,
                    List.of(new Media(MimeTypeUtils.IMAGE_PNG, e))
            );

            String response = chatModel.call(userMessage);
            System.out.printf("NumberPlateVisionTask.process: %s%n", response);
        });


    }

}
