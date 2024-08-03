package com.example.message_broker.consumer;

@Service
public class ConsumerService {
    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        // Handle the message
        System.out.println("Received message: " + message);
    }
}
