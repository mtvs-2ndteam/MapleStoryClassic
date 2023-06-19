package com.contrabass.mapleclassic.utils.contextconfiguration;

import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.repository.PlayerDAO;
import com.contrabass.mapleclassic.domain.repository.SkillDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

//@ComponentScan
@Configuration
public class PlayerContextConfiguration {
    @Bean
    public PlayerDAO pDAO() {
        return new PlayerDAO();
    }

    @Bean
    public PlayerDTO pDTO() {
        return new PlayerDTO("운영자1"
                , "마법사"
                , 50
                , 30
                , 30
                , 10000
                , 1000
                , 20000
                , 2000
                , 10
                , 0
                , 100
                , 5000
                , 10
                , 10
                , 20
                , 50
                , 0
                , 0
                , new ArrayList<>(new SkillDAO().getSkillList().values()));
    }
}
