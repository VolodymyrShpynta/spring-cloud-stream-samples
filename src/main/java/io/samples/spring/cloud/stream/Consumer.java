package io.samples.spring.cloud.stream;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @StreamListener(StreamBindings.REQUESTS_INPUT)
    @SendTo(StreamBindings.REPLIES_OUTPUT)
    public String receive(String message) {
        System.out.println("Consumer receives: " + message);
        System.out.println("Consumer sends: " + message);
        return message;
    }
}
