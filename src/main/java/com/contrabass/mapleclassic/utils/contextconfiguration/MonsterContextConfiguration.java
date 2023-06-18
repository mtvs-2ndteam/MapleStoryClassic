package com.contrabass.mapleclassic.utils.contextconfiguration;

import com.contrabass.mapleclassic.domain.entity.AttackInfoDTO;
import com.contrabass.mapleclassic.domain.entity.CloneMonsterDTO;
import com.contrabass.mapleclassic.domain.entity.henesys.boss.Zaqqum;
import com.contrabass.mapleclassic.domain.entity.henesys.normal.MonsterDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.contrabass.mapleclassic.application")
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
    @Qualifier("henesysBoseMonster")
    public MonsterDTO henesysBoseMonster(@Value("${henesys.boss.monster1.name:}") String monsterName,
                                         @Value("${henesys.boss.monster1.level:0}")int monsterLevel,
                                         @Value("${henesys.boss.monster1.hp:0}")int monsterHp,
                                         @Value("${henesys.boss.monster1.power:0}")int monsterPower,
                                         @Value("${henesys.boss.monster1.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("kerningCityMonster1")
    public MonsterDTO kerningCityMonster1(@Value("${kerningCity.normal.monster1.name:}") String monsterName,
                                          @Value("${kerningCity.normal.monster1.level:0}")int monsterLevel,
                                          @Value("${kerningCity.normal.monster1.hp:0}")int monsterHp,
                                          @Value("${kerningCity.normal.monster1.power:0}")int monsterPower,
                                          @Value("${kerningCity.normal.monster1.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("kerningCityMonster2")
    public MonsterDTO kerningCityMonster2(@Value("${kerningCity.normal.monster2.name:}") String monsterName,
                                          @Value("${kerningCity.normal.monster2.level:0}")int monsterLevel,
                                          @Value("${kerningCity.normal.monster2.hp:0}")int monsterHp,
                                          @Value("${kerningCity.normal.monster2.power:0}")int monsterPower,
                                          @Value("${kerningCity.normal.monster2.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("kerningCityMonster3")
    public MonsterDTO kerningCityMonster3(@Value("${kerningCity.normal.monster3.name:}") String monsterName,
                                          @Value("${kerningCity.normal.monster3.level:0}")int monsterLevel,
                                          @Value("${kerningCity.normal.monster3.hp:0}")int monsterHp,
                                          @Value("${kerningCity.normal.monster3.power:0}")int monsterPower,
                                          @Value("${kerningCity.normal.monster3.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("kerningCityMonster4")
    public MonsterDTO kerningCityMonster4(@Value("${kerningCity.normal.monster4.name:}") String monsterName,
                                          @Value("${kerningCity.normal.monster4.level:0}")int monsterLevel,
                                          @Value("${kerningCity.normal.monster4.hp:0}")int monsterHp,
                                          @Value("${kerningCity.normal.monster4.power:0}")int monsterPower,
                                          @Value("${kerningCity.normal.monster4.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("perionMonster1")
    public MonsterDTO perionMonster1(@Value("${perion.normal.monster1.name:}") String monsterName,
                                     @Value("${perion.normal.monster1.level:0}")int monsterLevel,
                                     @Value("${perion.normal.monster1.hp:0}")int monsterHp,
                                     @Value("${perion.normal.monster1.power:0}")int monsterPower,
                                     @Value("${perion.normal.monster1.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("perionMonster2")
    public MonsterDTO perionMonster2(@Value("${perion.normal.monster2.name:}") String monsterName,
                                     @Value("${perion.normal.monster2.level:0}")int monsterLevel,
                                     @Value("${perion.normal.monster2.hp:0}")int monsterHp,
                                     @Value("${perion.normal.monster2.power:0}")int monsterPower,
                                     @Value("${perion.normal.monster2.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("perionMonster3")
    public MonsterDTO perionMonster3(@Value("${perion.normal.monster3.name:}") String monsterName,
                                     @Value("${perion.normal.monster3.level:0}")int monsterLevel,
                                     @Value("${perion.normal.monster3.hp:0}")int monsterHp,
                                     @Value("${perion.normal.monster3.power:0}")int monsterPower,
                                     @Value("${perion.normal.monster3.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
    }

    @Bean
    @Qualifier("perionMonster4")
    public MonsterDTO perionMonster4(@Value("${perion.normal.monster4.name:}") String monsterName,
                                     @Value("${perion.normal.monster4.level:0}")int monsterLevel,
                                     @Value("${perion.normal.monster4.hp:0}")int monsterHp,
                                     @Value("${perion.normal.monster4.power:0}")int monsterPower,
                                     @Value("${perion.normal.monster4.dropMoney:0}")int monsterDropMoney) {

        return new MonsterDTO(monsterName, monsterLevel, monsterHp, monsterPower, monsterDropMoney);
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
