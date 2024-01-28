package com.personal.infostream.service;

import com.personal.infostream.model.Data;
import com.personal.infostream.model.test.DataTestOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestOptionsServiceIMpl implements TestOptionsService {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final KafkaDataService kafkaDataService;

    @Override
    public void sendMessage(DataTestOptions testOptions) {
        if (testOptions.getTypes().length > 0) {
            executorService.scheduleAtFixedRate(() -> {
                Data data = new Data();
                data.setSensorId(
                        (long) (Math.random() * 10)
                );
                data.setMeasurement(
                        (Math.random() * 5) + 15
                );
                data.setType(
                        testOptions.getTypes()[(int) (Math.random() * testOptions.getTypes().length)]g
                );
                data.setTimestamp(
                        LocalDateTime.now()
                );
                kafkaDataService.send(data);
            }, 0, testOptions.getDelay(), TimeUnit.SECONDS);

        }
    }
}
