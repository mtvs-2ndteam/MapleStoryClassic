package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.domain.entity.AttackInfoDTO;
import com.contrabass.mapleclassic.domain.entity.CloneMonsterDTO;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.entity.henesys.normal.MonsterDTO;
import com.contrabass.mapleclassic.domain.repository.MonsterRepository;
import com.contrabass.mapleclassic.domain.service.FightDomainService;
import org.springframework.stereotype.Service;

@Service
public class FightService {

    private final MonsterRepository monsterRepository;
    private final FightDomainService fightDomainService;
    private final AttackInfoDTO attackInfoDTO;
    private final CloneMonsterDTO cloneMonsterDTO;
    private final PlayerDTO playerDTO;

    public FightService(MonsterRepository monsterRepository, FightDomainService fightDomainService,
                        AttackInfoDTO attackInfoDTO, CloneMonsterDTO cloneMonsterDTO, PlayerDTO playerDTO) {
        this.monsterRepository = monsterRepository;
        this.fightDomainService = fightDomainService;
        this.attackInfoDTO = attackInfoDTO;
        this.cloneMonsterDTO = cloneMonsterDTO;
        this.playerDTO = playerDTO;
    }

    public CloneMonsterDTO getMonsterDBByIndex(String placeName, int index) {
        switch (placeName) {
            case "henesys":
                System.out.println(index);
                MonsterDTO monsterDTO = monsterRepository.getHenesysMonsterDB().get(index);
                cloneMonsterDTO.setMonsterHp(monsterDTO.getMonsterHp());
                cloneMonsterDTO.setMonsterLevel(monsterDTO.getMonsterLevel());
                cloneMonsterDTO.setMonsterName(monsterDTO.getMonsterName());
                cloneMonsterDTO.setMonsterPower(monsterDTO.getMonsterPower());
                cloneMonsterDTO.setMonsterDropMoney(monsterDTO.getMonsterDropMoney());
                return cloneMonsterDTO;
        }
        return null;
    }

    public AttackInfoDTO playerMonsterFight(CloneMonsterDTO cloneMonsterDTO) {
        int monsterHitDamage = fightDomainService.playerAttack(cloneMonsterDTO);
        int playerHitDamage = fightDomainService.monsterAttack(cloneMonsterDTO);
        attackInfoDTO.monsterHitDamage = monsterHitDamage;
        attackInfoDTO.playerHitDamage = playerHitDamage;
        attackInfoDTO.isMonsterDie = fightDomainService.checkDie(cloneMonsterDTO);
        attackInfoDTO.isPlayerDie = fightDomainService.playerCheckDie();
        return attackInfoDTO;
    }

    public PlayerDTO getPlayerDTO() {
        return playerDTO;
    }
}
