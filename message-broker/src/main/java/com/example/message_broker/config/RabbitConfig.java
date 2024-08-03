package com.example.message_broker.config;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", true);
    }

    @Bean
    public Exchange myExchange() {
        return new DirectExchange("myExchange");
    }

    @Bean
    public Binding binding(Queue myQueue, Exchange myExchange) {
        return BindingBuilder.bind(myQueue).to(myExchange).with("myRoutingKey").noargs();
    }
}
