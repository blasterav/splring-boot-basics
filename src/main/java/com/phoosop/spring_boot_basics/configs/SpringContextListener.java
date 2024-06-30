package com.phoosop.spring_boot_basics.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.Set;

@Slf4j
@Configuration
class SpringContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Set<Converter<?, ?>> converters;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        GenericConversionService genericConversionService = (GenericConversionService) conversionService;
        for (Converter<?, ?> converter : converters) {
            genericConversionService.addConverter(converter);
            log.info("CONVERTER REGISTERED {}", converter.getClass().getName());
        }
    }
}
