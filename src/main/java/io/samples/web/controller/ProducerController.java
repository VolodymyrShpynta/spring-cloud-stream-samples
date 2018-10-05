package io.samples.web.controller;

import io.samples.cloud.stream.Producer;
import io.samples.model.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "/stream-producer")
@Slf4j
@RequiredArgsConstructor
public class ProducerController {

    private final Producer producer;

    @PostMapping("/produce")
    public void produceMessages() {
        IntStream.range(1, 10)
                .forEach(id -> producer.send(
                        UserInfo.builder()
                                .id(id)
                                .build()));
    }
}
