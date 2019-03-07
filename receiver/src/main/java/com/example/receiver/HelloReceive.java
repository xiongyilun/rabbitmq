package com.example.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceive {
    @RabbitListener(queues="queue")    //监听器监听指定的Queue
    public void processC(String str) {

        System.out.println("Receive:"+str);
    }

    @RabbitListener(queues="queueTopic1")    //监听器监听指定的Queue
    public void topic1(String str) {

        System.out.println("Receive:"+str);
    }

    @RabbitListener(queues="queueTopic2")    //监听器监听指定的Queue
    public void topic2(String str) {

        System.out.println("Receive:"+str);
    }



}
