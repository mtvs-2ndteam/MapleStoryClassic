package com.contrabass.mapleclassic.utils.contextconfiguration;


import com.contrabass.mapleclassic.application.dto.SaunaDTO;
import com.contrabass.mapleclassic.application.dto.ShopDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.contrabass.mapleclassic.application")
public class MainContextConfiguration {
    @Bean
    public SaunaDTO saunaDTO() {
        return new SaunaDTO();
    }

    @Bean
    public ShopDTO shopDTO() {
        return new ShopDTO();
    }
}