package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.service.FightService;
import com.contrabass.mapleclassic.domain.entity.AttackInfoDTO;
import com.contrabass.mapleclassic.domain.entity.CloneMonsterDTO;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.entity.henesys.normal.MonsterDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Setter
@Controller("fightController")
public class FightController {

    private final FightService fightService;

    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    public CloneMonsterDTO getCloneMonster(String placeName, int index) {
        return fightService.getMonsterDBByIndex(placeName, index);
    }

    public PlayerDTO getPlayerDTO() {
        return fightService.getPlayerDTO();
    }

    public AttackInfoDTO playerMonsterFight(CloneMonsterDTO cloneMonsterDTO) {
        return fightService.playerMonsterFight(cloneMonsterDTO);
    }
}
