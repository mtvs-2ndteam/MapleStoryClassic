package com.contrabass.mapleclassic.utils.contextconfiguration;

import com.contrabass.mapleclassic.application.controller.SaunaController;
import com.contrabass.mapleclassic.application.service.SaunaService;
import com.contrabass.mapleclassic.application.view.SaunaView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SaunaContextConfiguration {
    @Bean
    @Scope("prototype")
    public SaunaController saunaController() {
        return new SaunaController();
    }

    @Bean
    @Scope("prototype")
    public SaunaService saunaService() {
        return new SaunaService();
    }

    @Bean
    @Scope("prototype")
    public SaunaView saunaView() {
        return new SaunaView();
    }


}
