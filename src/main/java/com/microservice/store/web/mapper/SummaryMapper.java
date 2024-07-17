package com.microservice.store.web.mapper;

import com.microservice.store.model.Summary;
import com.microservice.store.web.dto.SummaryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappable<Summary, SummaryDto> {

}
