package com.contrabass.mapleclassic.utils.contextconfiguration;

import com.contrabass.mapleclassic.application.dto.UserDTO;
import com.contrabass.mapleclassic.domain.repository.UserDAO;
import com.contrabass.mapleclassic.domain.service.UserDomainService;
import com.contrabass.mapleclassic.infra.UserDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserContextConfiguration {

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
    public UserDAO userDAO() {
        return new UserDAO();
    }
}
