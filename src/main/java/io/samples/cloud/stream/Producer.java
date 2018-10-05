package io.samples.cloud.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    private final StreamBindings streamBindings;

    public void send(String data) {
        System.out.println("Producer sends: " + data);
        streamBindings.requestsOutputChannel().send(MessageBuilder.withPayload(data).build());
    }

    @StreamListener(StreamBindings.REPLIES_INPUT)
    public void receive(String data) {
        System.out.println("Producer receives: " + data);
    }
}
