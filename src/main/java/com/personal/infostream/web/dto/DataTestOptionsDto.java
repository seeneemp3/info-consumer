package com.personal.infostream.web.dto;

import com.personal.infostream.model.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptionsDto {
    private int delay;
    private Data.Type[] types;
}
