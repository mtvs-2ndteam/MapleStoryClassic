package com.contrabass.mapleclassic;


import com.contrabass.mapleclassic.application.controller.GameController;
import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.UserView;
import com.contrabass.mapleclassic.domain.entity.UserDTO;
import com.contrabass.mapleclassic.domain.repository.UserRepository;
import com.contrabass.mapleclassic.infra.UserDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {
    @Bean
    @Scope("prototype")
    public GameController gameController() {
        return new GameController();
    }

    @Bean
    public MainView mainView() {
        return new MainView();
    }

    @Bean
    public UserView userView() {
        return new UserView();
    }

    @Bean
    public UserDTO userDTO() {
        return new UserDTO();
    }

    @Bean
    public UserDB userDB() {
        return new UserDB();
    }

    @Bean
    @Scope("prototype")
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
