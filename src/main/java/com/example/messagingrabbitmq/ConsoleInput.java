package com.example.messagingrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInput implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public ConsoleInput(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Chat started. Type messages:");

        while (true) {
            System.out.print("> ");
            String message = scanner.nextLine();

            rabbitTemplate.convertAndSend(
                    "spring-boot-exchange",
                    "",
                    message
            );
        }
    }
}
