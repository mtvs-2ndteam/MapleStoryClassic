package com.contrabass.mapleclassic.utils.contextconfiguration;

import com.contrabass.mapleclassic.application.controller.ShopController;
import com.contrabass.mapleclassic.application.service.ShopService;
import com.contrabass.mapleclassic.application.view.ShopView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ShopContextConfiguration {
    @Bean
    @Scope("prototype")
    public ShopView shopView() {
        return new ShopView();
    }

    @Bean
    @Scope("prototype")
    public ShopService shopService() {
        return new ShopService();
    }

    @Bean
    @Scope("prototype")
    public ShopController shopController() {
        return new ShopController();
    }

}
