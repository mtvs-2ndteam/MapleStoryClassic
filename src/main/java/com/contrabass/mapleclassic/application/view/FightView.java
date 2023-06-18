package com.contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.application.controller.FightController;
import com.contrabass.mapleclassic.domain.entity.AttackInfoDTO;
import com.contrabass.mapleclassic.domain.entity.CloneMonsterDTO;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.entity.henesys.normal.MonsterDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.contrabass.mapleclassic.Constant.SCANNER;

@Getter
@Setter
@Component("fightView")
public class FightView {

    private final FightController fightController;
    private AttackInfoDTO attackInfoDTO;
    private boolean run = true;

    @Autowired
    public FightView(FightController fightController){
        this.fightController = fightController;
    }

    public void printEntryFight() {
        System.out.println("==========전투 화면==========");
        System.out.println("1. 기본공격\n2. 스킬공격 ");
    }

    public void entryFight(CloneMonsterDTO CloneMonsterDTO, PlayerDTO playerDTO) {
        while(run){
            printEntryFight();
            switch (SCANNER.nextLine()) {
                case "1":
                    attackInfoDTO = fightController.playerMonsterFight(CloneMonsterDTO);
                    selectNormalAttack(CloneMonsterDTO, attackInfoDTO);
                    printPlayerAndMonsteInfo(CloneMonsterDTO, playerDTO);
                    break;
//                case "2":
//                    isMonsterDie = player.skillAttack(monster);
//                    fightView.selectSkillAttack(monster);
//                    isPlayerDie = monster.attack(player);
//                    fightService.checkFightEnd();
//                    break;
                default:
                    System.out.println("잘못된 값을 입력하셨습니다. 다시 입력하세요.");
                    break;
            }
            if (attackInfoDTO.isPlayerDie) {
                System.out.println("플레이어가 사망했다.");
                run = false;
            }
            else if(attackInfoDTO.isMonsterDie) {
                System.out.println(CloneMonsterDTO.getMonsterName() +  "를 쓰려트렸다!" + CloneMonsterDTO.getMonsterDropMoney() + "의 돈을 얻었다.");
                run = false;
            }
        }

    }

    public void printPlayerAndMonsteInfo(CloneMonsterDTO cloneMonsterDTO, PlayerDTO playerDTO) {
        System.out.println(cloneMonsterDTO.getMonsterName() + " : " + cloneMonsterDTO.getMonsterHp());
        System.out.println("플레이어의 hp는 : " + playerDTO.getBaseHp());
    }
    public void selectNormalAttack(CloneMonsterDTO cloneMonsterDTO, AttackInfoDTO attackInfoDTO) {
        System.out.println(cloneMonsterDTO.getMonsterName() + "에게 기본 공격을 가했다!");
        System.out.println("적에게" + attackInfoDTO.getMonsterHitDamage() + "의 데미지를 입혔다.");
    }

    public void selectSkillAttack(CloneMonsterDTO cloneMonsterDTO, AttackInfoDTO attackInfoDTO) {
        System.out.println(cloneMonsterDTO.getMonsterName() + "에게 스킬 공격을 가했다!");
        System.out.println("적에게" + attackInfoDTO.getMonsterHitDamage() + "의 데미지를 입혔다.");
    }
}
