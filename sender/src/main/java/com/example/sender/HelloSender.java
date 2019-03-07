package com.example.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate template;

    public void send() {
        template.convertAndSend("queue","hello,rabbit~");
    }

    //指定路由键为topic.message，queueTopic1和queueTopic2都能匹配上，Exchange会向两个队列都转发消息
    public void send1() {
        String context = "hi, i am message 1";
        template.convertAndSend("exchange", "topic.message", context);
    }

    //指定路由键为topic.message，只有queueTopic2都能匹配上，Exchange只会向queueTopic2转发消息
    public void send2() {
        String context = "hi, i am messages 2";
        template.convertAndSend("exchange", "topic.random", context);
    }
}
