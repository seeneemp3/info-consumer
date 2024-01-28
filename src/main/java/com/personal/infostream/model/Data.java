package com.personal.infostream.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Data {
    private Long sensorId;
    private LocalDateTime timestamp;
    private double measurement;
    private Type type;

    public enum Type {
        TEMP,
        VOLT,
        WATT
    }
}
