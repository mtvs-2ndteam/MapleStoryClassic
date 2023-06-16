package com.contrabass.mapleclassic;

import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.service.PlayerDAO;
import com.contrabass.mapleclassic.domain.service.SkillDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@ComponentScan
@Configuration
public class PlayerContextConfiguration {
    @Bean
    public PlayerDAO plogic() {
        return new PlayerDAO();
    }

    @Bean
    public PlayerDTO pDTO(){
        return new PlayerDTO(1
                , 1000
                , 100
                , 1000
                , 100
                , 10
                , 0
                , 100
                , 1000
                , 10
                , 10
                , 20
                , 50
                , 0
                , 0
                , new ArrayList<>(new SkillDAO().getSkillList().values()));
    }
}
