package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.application.controller.FightController;
import com.contrabass.mapleclassic.domain.entity.AttackInfoDTO;
import com.contrabass.mapleclassic.domain.entity.CloneMonsterDTO;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.entity.henesys.normal.MonsterDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Getter
@Setter
@Service
public class FightDomainService {
    private int resultDamage = 0;

    private Random r = new Random();
    private int temp = 0;
    private final PlayerDTO playerDTO;

    @Autowired
    public FightDomainService(PlayerDTO playerDTO) {
        this.playerDTO = playerDTO;
    }

    public int playerAttack(CloneMonsterDTO cloneMonsterDTO) {
        int resultDamage = playerDamageLogic();
        cloneMonsterDTO.setMonsterHp(cloneMonsterDTO.getMonsterHp() - resultDamage);
        return resultDamage;
    }

    public int playerDamageLogic() {
        temp = r.nextInt(100);
        if (temp >= 0 && temp < playerDTO.getCriPercent()) {
            resultDamage = playerDTO.getAtk() * 2 + playerDTO.getAtk() * 2 * playerDTO.getCriDamage() / 100;
        } else {
            resultDamage = playerDTO.getAtk();
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
