package com.personal.infostream.web.controller;

import com.personal.infostream.model.Data;
import com.personal.infostream.service.KafkaDataService;
import com.personal.infostream.web.dto.DataDto;
import com.personal.infostream.web.mapper.DataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/data")
@RequiredArgsConstructor
public class DataController {
    private final KafkaDataService kafkaDataService;
    private final DataMapper dataMapper;
    @PostMapping("/send")
    public void send(@RequestBody DataDto dto){
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);
    }
}
