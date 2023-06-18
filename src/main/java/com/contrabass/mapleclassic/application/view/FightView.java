package com.contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.application.controller.FightController;
import com.contrabass.mapleclassic.domain.entity.AttackInfoDTO;
import com.contrabass.mapleclassic.domain.entity.CloneMonsterDTO;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.entity.SkillDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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
        System.out.println("========== 전투 화면 ==========");
        System.out.println("1. 기본공격\n2. 스킬공격 ");
    }

    public void entryFight(CloneMonsterDTO cloneMonsterDTO, PlayerDTO playerDTO) {
        run = true;
        while(run){
            printEntryFight();
            switch (SCANNER.nextInt()) {
                case 1:
                    attackInfoDTO = fightController.playerMonsterFight(cloneMonsterDTO);
                    selectNormalAttack(cloneMonsterDTO, attackInfoDTO);
                    printPlayerAndMonsteInfo(cloneMonsterDTO, playerDTO);
                    break;
                case 2:
                    ArrayList<SkillDTO> skills = playerDTO.getSkills();
                    int index;
                    System.out.println("========== 스킬 목록 ==========");
                    for(int i = 0; i <+ skills.size(); i++){
                        System.out.println(i+1 + ". "+ skills.get(i).getSkillName());
                    }
                    while(true){
                        index = SCANNER.nextInt();
                        if (index <= skills.size() && index > 0) {
                            break;
                        } else {
                            System.out.println("잘못된 숫자를 입력하셨습니다.");
                        }
                    }
                    attackInfoDTO = fightController.playerMonsterFight(cloneMonsterDTO, index - 1);
                    selectSkillAttack(cloneMonsterDTO, attackInfoDTO);
                    printPlayerAndMonsteInfo(cloneMonsterDTO, playerDTO);
                    break;
                default:
                    System.out.println("잘못된 값을 입력하셨습니다. 다시 입력하세요.");
                    break;
            }
            if (attackInfoDTO.isPlayerDie) {
                System.out.println("플레이어가 사망했다.");
                run = false;
            }
            else if(attackInfoDTO.isMonsterDie) {
                System.out.println(cloneMonsterDTO.getMonsterName() +  "를 쓰려트렸다!" + cloneMonsterDTO.getMonsterDropMoney() + "의 돈을 얻었다.");
                playerDTO.setMeso(playerDTO.getMeso() + cloneMonsterDTO.getMonsterDropMoney());
                run = false;
            }
        }
    }

    public void printPlayerAndMonsteInfo(CloneMonsterDTO cloneMonsterDTO, PlayerDTO playerDTO) {
        System.out.println(cloneMonsterDTO.getMonsterName() + " HP : " + cloneMonsterDTO.getMonsterHp());
        System.out.println("플레이어 HP : " + playerDTO.getBaseHp());
    }

    public void selectNormalAttack(CloneMonsterDTO cloneMonsterDTO, AttackInfoDTO attackInfoDTO) {
        System.out.println(cloneMonsterDTO.getMonsterName() + "에게 기본 공격을 가했다!");
        System.out.println("적에게 " + attackInfoDTO.getMonsterHitDamage() + "의 데미지를 입혔다.");
    }


    public void selectSkillAttack(CloneMonsterDTO cloneMonsterDTO, AttackInfoDTO attackInfoDTO) {
        System.out.println(cloneMonsterDTO.getMonsterName() + "에게 스킬 공격을 가했다!");
        System.out.println("적에게 " + attackInfoDTO.getMonsterHitDamage() + "의 데미지를 입혔다.");
    }
}
