package com.company.generatecheck.mapper;

import com.company.generatecheck.dto.CheckDto;
import com.company.generatecheck.model.Check;
import org.mapstruct.Mapper;

@Mapper
public interface CheckMapper {

    CheckDto convert(Check check);
}
