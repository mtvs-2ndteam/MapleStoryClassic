package com.contrabass.mapleclassic.domain.repository;

import com.contrabass.mapleclassic.domain.entity.henesys.normal.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Getter
@Repository("monsterRepository")
public class MonsterRepository {

    private Map<Integer, MonsterDTO> henesysMonsterDB = new HashMap<>();
    private Map<Integer, MonsterDTO> kerningCityMonsterDB = new HashMap<>();
    private Map<Integer, MonsterDTO> perionMonsterDB = new HashMap<>();
    private Map<Integer, MonsterDTO> eliniaMonsterDB = new HashMap<>();

    @Autowired
    public MonsterRepository(@Qualifier("henesysMonster1")MonsterDTO henesysMonster1,
                             @Qualifier("henesysMonster2")MonsterDTO henesysMonster2,
                             @Qualifier("henesysMonster3")MonsterDTO henesysMonster3,
                             @Qualifier("henesysMonster4")MonsterDTO henesysMonster4,
                             @Qualifier("henesysBoseMonster")MonsterDTO henesysBoseMonster){
        henesysMonsterDB.put(1, henesysMonster1);
        henesysMonsterDB.put(2, henesysMonster2);
        henesysMonsterDB.put(3, henesysMonster3);
        henesysMonsterDB.put(4, henesysMonster4);
        henesysMonsterDB.put(5, henesysBoseMonster);
    }
}
