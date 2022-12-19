package com.company.generatecheck.config;

import com.company.generatecheck.mapper.CheckMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CheckMapper checkMapper() {
        return Mappers.getMapper(CheckMapper.class);
    }

}
