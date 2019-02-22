package com.example.receiver.Configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverConf {
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }
}
