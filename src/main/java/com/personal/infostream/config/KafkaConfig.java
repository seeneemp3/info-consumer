package com.personal.infostream.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;
    @Value("${producer.keySerializer}")
    private String keySerializer;
    @Value("${producer.valueSerializer}")
    private String valueSerializer;

    @Bean
    public NewTopic tempTopic(){
        return TopicBuilder.name("temperature-data")
                .partitions(3)
                .replicas(3)
                .config(
                TopicConfig.RETENTION_MS_CONFIG,
                String.valueOf(Duration.ofDays(7).toMillis())
        )
                .build();
    }

    @Bean
    public NewTopic voltTopic(){
        return TopicBuilder.name("volt-data")
                .partitions(3)
                .replicas(3)
                .config(
                        TopicConfig.RETENTION_MS_CONFIG,
                        String.valueOf(Duration.ofDays(7).toMillis())
                )
                .build();
    }

    @Bean
    public NewTopic wattTopic(){
        return TopicBuilder.name("watt-data")
                .partitions(3)
                .replicas(3)
                .config(
                        TopicConfig.RETENTION_MS_CONFIG,
                        String.valueOf(Duration.ofDays(7).toMillis())
                )
                .build();
    }

    @Bean
    public SenderOptions<String, Object> senderOptions() {
        Map<String, Object> props = new HashMap<>(3);
        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                servers
        );
        props.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                keySerializer
        );
        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
               valueSerializer
        );
        return SenderOptions.create(props);
    }

    @Bean
    public KafkaSender<String, Object> sender(
            SenderOptions<String, Object> senderOptions
    ) {
        return KafkaSender.create(senderOptions);
    }

}
