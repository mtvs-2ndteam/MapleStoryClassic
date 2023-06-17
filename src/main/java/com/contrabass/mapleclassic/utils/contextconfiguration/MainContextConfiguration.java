package com.contrabass.mapleclassic.utils.contextconfiguration;


import com.contrabass.mapleclassic.application.controller.GameController;
import com.contrabass.mapleclassic.application.controller.MapController;
import com.contrabass.mapleclassic.application.controller.ShopController;
import com.contrabass.mapleclassic.application.service.GameService;
import com.contrabass.mapleclassic.application.service.ShopService;
import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.MapView;
import com.contrabass.mapleclassic.application.view.ShopView;
import com.contrabass.mapleclassic.domain.service.GameDomainService;
import com.contrabass.mapleclassic.utils.MainException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainContextConfiguration {
    @Bean
    @Scope("prototype")
    public MainView mainView() {
        return new MainView();
    }

    @Bean
    @Scope("prototype")
    public GameController gameController() {
        return new GameController();
    }

    @Bean
    @Scope("prototype")
    public GameService gameService() {
        return new GameService();
    }

    @Bean
    @Scope("prototype")
    public GameDomainService gameDomainService() {
        return new GameDomainService();
    }


    @Bean
    @Scope("prototype")
    public MainException mainException() {
        return new MainException();
    }


    @Bean
    @Scope("prototype")
    public MapController mapController() {
        return new MapController();
    }

    @Bean
    @Scope("prototype")
    public MapView mapView() {
        return new MapView();
    }


}
