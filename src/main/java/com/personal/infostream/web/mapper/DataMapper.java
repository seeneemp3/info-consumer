package com.personal.infostream.web.mapper;

import com.personal.infostream.model.Data;
import com.personal.infostream.web.dto.DataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {

}
