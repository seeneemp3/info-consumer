package com.personal.infostream.service;

import com.personal.infostream.model.Data;

public interface KafkaDataService {
    void send(Data data);
}
