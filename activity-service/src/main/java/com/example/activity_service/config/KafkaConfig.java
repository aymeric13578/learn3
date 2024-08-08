package com.example.activity_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.MessageListener;

@Configuration
@EnableKafka
public class KafkaConfig {
    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(ProducerFactory<String, Object> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, Object> messageListenerContainer(ConsumerFactory<String, Object> consumerFactory) {
        ContainerProperties containerProps = new ContainerProperties("activity-topic");
        containerProps.setMessageListener(new MessageListener<String, Object>() {
            @Override
            public void onMessage(org.apache.kafka.clients.consumer.ConsumerRecord<String, Object> record) {
                // Process the message
            }
        });
        return new ConcurrentMessageListenerContainer<>(consumerFactory, containerProps);
    }
}
