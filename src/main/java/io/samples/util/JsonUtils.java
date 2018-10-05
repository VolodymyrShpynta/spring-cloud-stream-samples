package io.samples.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static <T> String toJsonString(T data) {
        return objectMapper.writeValueAsString(data);
    }

    @SneakyThrows
    public static <T> T readValue(String content, Class<T> valueType) {
        return objectMapper.readValue(content, valueType);
    }
}
