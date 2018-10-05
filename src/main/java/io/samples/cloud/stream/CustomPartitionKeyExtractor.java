package io.samples.cloud.stream;

import io.samples.model.UserInfo;
import io.samples.util.JsonUtils;
import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("customPartitionKeyExtractor") //TODO: investigate why partitioning doesn't work if this component is specified in the application.yaml as partitionKeyExtractorName.
public class CustomPartitionKeyExtractor implements PartitionKeyExtractorStrategy {

    @Override
    public Object extractKey(Message<?> message) {
        return Optional.ofNullable(message)
                .map(Message::getPayload)
                .filter(String.class::isInstance)
                .map(String.class::cast)
                .map(payload -> JsonUtils.readValue(payload, UserInfo.class))
                .map(UserInfo::getId)
                .orElseThrow(() -> new IllegalArgumentException("Can't read message: " + message));
    }
}
