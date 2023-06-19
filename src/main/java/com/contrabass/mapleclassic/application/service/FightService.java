package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.domain.entity.AttackInfoDTO;
import com.contrabass.mapleclassic.domain.entity.CloneMonsterDTO;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.entity.MonsterDTO;
import com.contrabass.mapleclassic.domain.repository.MonsterDAO;
import com.contrabass.mapleclassic.domain.service.FightDomainService;
import org.springframework.stereotype.Service;

@Service
public class FightService {

    private final MonsterDAO monsterRepository;
    private final FightDomainService fightDomainService;
    private final AttackInfoDTO attackInfoDTO;
    private final CloneMonsterDTO cloneMonsterDTO;
    private final PlayerDTO playerDTO;

    public FightService(MonsterDAO monsterRepository, FightDomainService fightDomainService,
                        AttackInfoDTO attackInfoDTO, CloneMonsterDTO cloneMonsterDTO, PlayerDTO playerDTO) {
        this.monsterRepository = monsterRepository;
        this.fightDomainService = fightDomainService;
        this.attackInfoDTO = attackInfoDTO;
        this.cloneMonsterDTO = cloneMonsterDTO;
        this.playerDTO = playerDTO;
    }

    public CloneMonsterDTO getMonsterDBByIndex(String placeName, int index) {
        MonsterDTO monsterDTO;
        switch (placeName) {
            case "헤네시스":
                monsterDTO = monsterRepository.getHenesysMonsterDB().get(index);
                cloneMonsterDTO.setMonsterHp(monsterDTO.getMonsterHp());
                cloneMonsterDTO.setMonsterLevel(monsterDTO.getMonsterLevel());
                cloneMonsterDTO.setMonsterName(monsterDTO.getMonsterName());
                cloneMonsterDTO.setMonsterPower(monsterDTO.getMonsterPower());
                cloneMonsterDTO.setMonsterDropMoney(monsterDTO.getMonsterDropMoney());
                cloneMonsterDTO.setExp(monsterDTO.getExp());
                return cloneMonsterDTO;
            case "커닝시티":
                monsterDTO = monsterRepository.getKerningCityMonsterDB().get(index);
                cloneMonsterDTO.setMonsterHp(monsterDTO.getMonsterHp());
                cloneMonsterDTO.setMonsterLevel(monsterDTO.getMonsterLevel());
                cloneMonsterDTO.setMonsterName(monsterDTO.getMonsterName());
                cloneMonsterDTO.setMonsterPower(monsterDTO.getMonsterPower());
                cloneMonsterDTO.setMonsterDropMoney(monsterDTO.getMonsterDropMoney());
                cloneMonsterDTO.setExp(monsterDTO.getExp());
                return cloneMonsterDTO;
            case "페리온":
                monsterDTO = monsterRepository.getPerionMonsterDB().get(index);
                cloneMonsterDTO.setMonsterHp(monsterDTO.getMonsterHp());
                cloneMonsterDTO.setMonsterLevel(monsterDTO.getMonsterLevel());
                cloneMonsterDTO.setMonsterName(monsterDTO.getMonsterName());
                cloneMonsterDTO.setMonsterPower(monsterDTO.getMonsterPower());
                cloneMonsterDTO.setMonsterDropMoney(monsterDTO.getMonsterDropMoney());
                cloneMonsterDTO.setExp(monsterDTO.getExp());
                return cloneMonsterDTO;
        }
        return null;
    }

    public AttackInfoDTO playerMonsterFight(CloneMonsterDTO cloneMonsterDTO) {
        int monsterHitDamage = fightDomainService.playerAttack(cloneMonsterDTO);
        int playerHitDamage = fightDomainService.monsterAttack(cloneMonsterDTO);
        attackInfoDTO.setMonsterHitDamage(monsterHitDamage);
        attackInfoDTO.setPlayerHitDamage(playerHitDamage);
        attackInfoDTO.isMonsterDie = fightDomainService.checkDie(cloneMonsterDTO);
        attackInfoDTO.isPlayerDie = fightDomainService.playerCheckDie();
        return attackInfoDTO;
    }

    public AttackInfoDTO playerMonsterFight(CloneMonsterDTO cloneMonsterDTO, int skillIndex) {
        int monsterHitDamage = fightDomainService.playerSkillAttack(cloneMonsterDTO, skillIndex);
        int playerHitDamage = fightDomainService.monsterAttack(cloneMonsterDTO);
        attackInfoDTO.setMonsterHitDamage(monsterHitDamage);
        attackInfoDTO.setPlayerHitDamage(playerHitDamage);
        attackInfoDTO.isMonsterDie = fightDomainService.checkDie(cloneMonsterDTO);
        attackInfoDTO.isPlayerDie = fightDomainService.playerCheckDie();
        return attackInfoDTO;
    }

    public PlayerDTO getPlayerDTO() {
        return playerDTO;
    }
}
