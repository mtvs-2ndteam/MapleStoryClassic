package com.contrabass.mapleclassic.domain.repository;

import com.contrabass.mapleclassic.application.dto.MonsterDTO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Getter
@Repository("monsterRepository")
public class MonsterDAO {

    private final Map<Integer, MonsterDTO> henesysMonsterDB = new HashMap<>();
    private final Map<Integer, MonsterDTO> kerningCityMonsterDB = new HashMap<>();
    private final Map<Integer, MonsterDTO> perionMonsterDB = new HashMap<>();
    private final Map<Integer, MonsterDTO> eliniaMonsterDB = new HashMap<>();

    @Autowired
    public MonsterDAO(@Qualifier("henesysMonster1") MonsterDTO henesysMonster1,
                      @Qualifier("henesysMonster2") MonsterDTO henesysMonster2,
                      @Qualifier("henesysMonster3") MonsterDTO henesysMonster3,
                      @Qualifier("henesysMonster4") MonsterDTO henesysMonster4,
                      @Qualifier("henesysBoseMonster") MonsterDTO henesysBoseMonster,

                      @Qualifier("kerningCityMonster1") MonsterDTO kerningCityMonster1,
                      @Qualifier("kerningCityMonster2") MonsterDTO kerningCityMonster2,
                      @Qualifier("kerningCityMonster3") MonsterDTO kerningCityMonster3,
                      @Qualifier("kerningCityMonster4") MonsterDTO kerningCityMonster4,

                      @Qualifier("perionMonster1") MonsterDTO perionMonster1,
                      @Qualifier("perionMonster2") MonsterDTO perionMonster2,
                      @Qualifier("perionMonster3") MonsterDTO perionMonster3,
                      @Qualifier("perionMonster4") MonsterDTO perionMonster4) {
        henesysMonsterDB.put(1, henesysMonster1);
        henesysMonsterDB.put(2, henesysMonster2);
        henesysMonsterDB.put(3, henesysMonster3);
        henesysMonsterDB.put(4, henesysMonster4);
        henesysMonsterDB.put(5, henesysBoseMonster);

        kerningCityMonsterDB.put(1, kerningCityMonster1);
        kerningCityMonsterDB.put(2, kerningCityMonster2);
        kerningCityMonsterDB.put(3, kerningCityMonster3);
        kerningCityMonsterDB.put(4, kerningCityMonster4);

        perionMonsterDB.put(1, perionMonster1);
        perionMonsterDB.put(2, perionMonster2);
        perionMonsterDB.put(3, perionMonster3);
        perionMonsterDB.put(4, perionMonster4);
    }
}
