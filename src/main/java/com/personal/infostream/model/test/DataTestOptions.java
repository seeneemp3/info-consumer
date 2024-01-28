package com.personal.infostream.model.test;

import com.personal.infostream.model.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptions {
    private int delay;
    private Data.Type[] types;
}
