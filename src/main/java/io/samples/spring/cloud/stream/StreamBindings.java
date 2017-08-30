package io.samples.spring.cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamBindings {
    String REQUESTS_OUTPUT = "requests_output";
    String REQUESTS_INPUT = "requests_input";

    String REPLIES_INPUT = "replies_input";
    String REPLIES_OUTPUT = "replies_output";

    // producer channels
    @Output(REQUESTS_OUTPUT)
    MessageChannel requestsOutputChannel();

    @Input(REPLIES_INPUT)
    SubscribableChannel repliesInputChannel();

    // consumer channels
    @Input(REQUESTS_INPUT)
    SubscribableChannel requestsInputChannel();

    @Output(REPLIES_OUTPUT)
    MessageChannel repliesOutputChannel();
}
