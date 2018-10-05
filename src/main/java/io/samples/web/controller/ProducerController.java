package io.samples.web.controller;

import io.samples.cloud.stream.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stream-producer")
@Slf4j
@RequiredArgsConstructor
public class ProducerController {

    private final Producer producer;

    @PostMapping("/produce")
    public void produceMessages() {
        producer.send("{\"id\": 1}");
        producer.send("{\"id\": 2}");
        producer.send("{\"id\": 3}");
    }
}
