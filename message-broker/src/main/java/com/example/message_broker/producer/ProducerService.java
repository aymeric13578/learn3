package com.example.message_broker.producer;

@Service
public class ProducerService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("myExchange", "myRoutingKey", message);
    }
}
