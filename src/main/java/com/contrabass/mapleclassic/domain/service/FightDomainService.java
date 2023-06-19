package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.entity.CloneMonsterDTO;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.repository.PlayerDAO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Component
public class FightDomainService {
    private final PlayerDAO playerDAO;
    private int resultDamage = 0;

    private Random r = new Random();
    private int temp = 0;
    private final PlayerDTO playerDTO;

    @Autowired
    public FightDomainService(PlayerDTO playerDTO, PlayerDAO playerDAO)
    {
        this.playerDTO = playerDTO;
        this.playerDAO = playerDAO;
    }

    public int playerAttack(CloneMonsterDTO cloneMonsterDTO) {
        int resultDamage = playerDamageLogic(playerDTO.getAtk(), playerDTO.getCriPercent(), playerDTO.getCriDamage());
        cloneMonsterDTO.setMonsterHp(cloneMonsterDTO.getMonsterHp() - resultDamage);
        return resultDamage;
    }

    public int playerSkillAttack(CloneMonsterDTO cloneMonsterDTO, int index) {
        int resultDamage = playerDamageLogic(playerDTO.getSkills().get(index).getSkillDmg(), playerDTO.getCriPercent(), playerDTO.getCriDamage());
        cloneMonsterDTO.setMonsterHp(cloneMonsterDTO.getMonsterHp() - resultDamage);
        return resultDamage;
    }

    public int playerDamageLogic(int atk, int criPercent, int criDamage) {
        temp = r.nextInt(100);
        if (temp >= 0 && temp < criPercent) {
            resultDamage = atk * 2 + atk * 2 * criDamage / 100;
        } else {
            resultDamage = atk;
        }

        return resultDamage;
    }

    public int monsterAttack(CloneMonsterDTO cloneMonsterDTO) {
        int resultDamage = cloneMonsterDTO.getMonsterPower();
        playerDTO.setBaseHp(playerDTO.getBaseHp() - resultDamage);
        return resultDamage;
    }

    public boolean checkDie(CloneMonsterDTO cloneMonsterDTO) {
        if (cloneMonsterDTO.getMonsterHp() <= 0) {
            playerDAO.expUp(cloneMonsterDTO.getExp());
            return true;
        }
        return false;
    }

    public boolean playerCheckDie() {
        if (playerDTO.getBaseHp() <= 0) {
            return true;
        }
        return false;
    }

    //
    //    public boolean playerSkillAttack(MonsterDTO monster) {
//        monster.hit(skillPower);
//        return monster.checkDie();
//    }
//
//    public boolean checkDie() {
//        if (hp <= 0) {
//            die();
//            return true;
//        }
//        return false;
//    }
//
//    public void hit(int monsterPower) {
//        this.hp -= monsterPower;
//    }
//
//    /// 몬스터
//
//    public boolean attack(Player player) {
//        player.hit(monsterPower);
//        return player.checkDie();
//    }
//
//    public boolean checkDie(){
//        if (monsterHp <= 0) {
//            die();
//            return true;
//        }
//        return false;
//    }
//
//    public void hit(int playerPower) {
//        this.monsterHp -= playerPower;
//        checkDie();
//    }
}
