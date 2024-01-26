package com.personal.infostream.service;

import com.personal.infostream.model.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.sender.KafkaSender;

@Service
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService{
    private final KafkaSender<String, Object> kafkaSender;
    @Override
    public void send(Data data) {

    }
}
