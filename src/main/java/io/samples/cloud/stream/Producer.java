package io.samples.cloud.stream;

import io.samples.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import static io.samples.util.JsonUtils.toJsonString;

@Component
@RequiredArgsConstructor
public class Producer {

    private final StreamBindings streamBindings;

    public void send(UserInfo data) {
        System.out.println("Producer sends: " + data);
        streamBindings.requestsOutputChannel().send(
                MessageBuilder.withPayload(toJsonString(data)).build());
    }

    @StreamListener(StreamBindings.REPLIES_INPUT)
    public void receive(String data) {
        System.out.println("Producer receives: " + data);
    }
}
