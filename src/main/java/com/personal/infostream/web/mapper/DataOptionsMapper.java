package com.personal.infostream.web.mapper;

import com.personal.infostream.model.test.DataTestOptions;
import com.personal.infostream.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {

}
