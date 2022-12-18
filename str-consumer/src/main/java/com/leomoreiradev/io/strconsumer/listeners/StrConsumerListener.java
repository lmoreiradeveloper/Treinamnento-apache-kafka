package com.leomoreiradev.io.strconsumer.listeners;

import com.leomoreiradev.io.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1") //usando listener customizado
    public void create(String message) {
        log.info("CREATE ::: Receive  message {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Receive  message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Receive  message {}", message);
    }

}