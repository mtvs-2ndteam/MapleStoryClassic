package com.contrabass.mapleclassic.utils.contextconfiguration;

import com.contrabass.mapleclassic.domain.entity.AttackInfoDTO;
import com.contrabass.mapleclassic.domain.entity.CloneMonsterDTO;
import com.contrabass.mapleclassic.domain.entity.henesys.boss.Zaqqum;
import com.contrabass.mapleclassic.domain.entity.henesys.normal.MonsterDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.contrabass.mapleclassic.application.controller")
@PropertySource("mapleclassic/domain/entity/henesys/normal/map-monsters.properties")
public class MonsterContextConfiguration {
    @Bean
    @Qualifier("henesysMonster1")
    public MonsterDTO henesysMonster1(@Value("${henesys.normal.monster1.name:}") String monsterName,
                                      @Value("${henesys.normal.monster1.level:0}")int monsterLevel,
                                      @Value("${henesys.normal.monster1.hp:0}")int monsterHp,
                                      @Value("${henesys.normal.monster1.power:0}")int monsterPower,
                                      @Value("${henesys.normal.monster1.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("henesysMonster2")
    public MonsterDTO henesysMonster2(@Value("${henesys.normal.monster2.name:}") String monsterName,
                                      @Value("${henesys.normal.monster2.level:0}")int monsterLevel,
                                      @Value("${henesys.normal.monster2.hp:0}")int monsterHp,
                                      @Value("${henesys.normal.monster2.power:0}")int monsterPower,
                                      @Value("${henesys.normal.monster2.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("henesysMonster3")
    public MonsterDTO henesysMonster3(@Value("${henesys.normal.monster3.name:}") String monsterName,
                                      @Value("${henesys.normal.monster3.level:0}")int monsterLevel,
                                      @Value("${henesys.normal.monster3.hp:0}")int monsterHp,
                                      @Value("${henesys.normal.monster3.power:0}")int monsterPower,
                                      @Value("${henesys.normal.monster3.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("henesysMonster4")
    public MonsterDTO henesysMonster4(@Value("${henesys.normal.monster4.name:}") String monsterName,
                                      @Value("${henesys.normal.monster4.level:0}")int monsterLevel,
                                      @Value("${henesys.normal.monster4.hp:0}")int monsterHp,
                                      @Value("${henesys.normal.monster4.power:0}")int monsterPower,
                                      @Value("${henesys.normal.monster4.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    public MonsterDTO henesysBoseMonster(@Value("${henesys.boss.monster1.name:}") String monsterName,
                                         @Value("${henesys.boss.monster1.level:0}")int monsterLevel,
                                         @Value("${henesys.boss.monster1.hp:0}")int monsterHp,
                                         @Value("${henesys.boss.monster1.power:0}")int monsterPower,
                                         @Value("${henesys.boss.monster1.dropMoney:0}")int monsterDropMoney) {

        return new Zaqqum(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    public AttackInfoDTO attackInfoDTO() {

        return new AttackInfoDTO(false, false, 0, 0);
    }

    @Bean
    public CloneMonsterDTO cloneMonsterDTO() {
        return new CloneMonsterDTO();
    }
}
