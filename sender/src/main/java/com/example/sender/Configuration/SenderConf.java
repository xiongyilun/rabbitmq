package com.example.sender.Configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConf {

    @Bean
    public Queue queue() {
        return new Queue("queue");
    }

    @Bean
    public Queue queueMessage() {
        return new Queue("queueTopic1");
    }

    @Bean
    public Queue queueMessages() {
        return new Queue("queueTopic2");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    //将队列topic.message队列与exchange绑定，binding_key为topic.message,就是完全匹配
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    //将队列topic.messages队列与exchange绑定，binding_key为topic.#,模糊匹配
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
