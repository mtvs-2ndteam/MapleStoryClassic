package com.contrabass.mapleclassic.utils.contextconfiguration;

import com.contrabass.mapleclassic.application.view.UserView;
import com.contrabass.mapleclassic.domain.entity.UserDTO;
import com.contrabass.mapleclassic.domain.repository.UserRepository;
import com.contrabass.mapleclassic.domain.service.UserDomainService;
import com.contrabass.mapleclassic.infra.UserDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserContextConfiguration {
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
    public UserDomainService userDomainService() {
        return new UserDomainService();
    }

    @Bean
    @Scope("prototype")
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
