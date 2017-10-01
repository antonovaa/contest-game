package com.controller;

import com.model.Greeting;
import com.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
/**
 * Created by Lord on 26.09.2017.
 */
@Controller
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        System.out.println("inside greeting");
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @SubscribeMapping("/topic/greetings")
    public Greeting try1() {
        System.out.println("inside TRY 1");
        return new Greeting("Hello, " + "TRY 1" + "!");
    }
}
