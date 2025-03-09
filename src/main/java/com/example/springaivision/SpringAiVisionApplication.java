package com.example.springaivision;

import com.example.springaivision.tasks.ChatMessageVisionTask;
import com.example.springaivision.tasks.NumberPlateVisionTask;
import com.example.springaivision.tasks.TerminalVisionTask;
import com.example.springaivision.tasks.WebsiteVisionTask;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringAiVisionApplication implements CommandLineRunner {
    private final NumberPlateVisionTask numberPlateVisionTask;
    private final ChatMessageVisionTask chatMessageVisionTask;
    private final WebsiteVisionTask websiteVisionTask;
    private final TerminalVisionTask terminalVisionTask;

    public static void main(String[] args) {
        SpringApplication.run(SpringAiVisionApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // load image files from resources
        System.out.println("""
                1. Read text from website image
                2. Read text from chat messages image
                3. Read text from terminal screen shot image
                4. Read car number plate text from images
                0. Exit
                """);
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number (1-4) to select a vision task or 0 to exit:");
            int choice = input.nextInt();
            switch (choice) {
                case 0 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                case 1 -> {
                    System.out.println("Website Vision Task: Capture and print human-readable text from the website image");
                    websiteVisionTask.process();
                }
                case 2 -> {
                    System.out.println("Chat Message Vision Task: Capture and print human-readable text from the chat messages image");
                    chatMessageVisionTask.process();
                }
                case 3 -> {
                    System.out.println("Terminal Vision Task: Capture and print human-readable text from the terminal window image");
                    terminalVisionTask.process();
                }
                case 4 -> {
                    System.out.println("Number Plate Vision Task: Capture and print human-readable text from the car number plate image");
                    numberPlateVisionTask.process();
                }
            }
        }
    }
}
