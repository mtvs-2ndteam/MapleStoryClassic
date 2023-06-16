package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("oad")
public class PlayerDAO {
    @Autowired
    private PlayerDTO dto;

    void testExpUp(int exp){
        if (dto.getBaseExp()+exp >= dto.getMaxExp()) {
            int baseExp=(dto.getBaseExp()+exp)-dto.getMaxExp();
            int MaxExp=dto.getMaxExp()*2;
            dto.setStatPoint(5);
            dto.setSkillPoint(1);
            dto.setBaseExp(baseExp);
            dto.setMaxExp(MaxExp);
            dto.setBaseHp(dto.getMaxHp());
            dto.setBaseMp(dto.getMaxMp());
            dto.setLevel(dto.getLevel()+1);
            System.out.println("레벨업 했습니다!!!\n경험치 :"+dto.getBaseExp()+" / "+dto.getMaxExp());
        }else{
            dto.setBaseExp(dto.getBaseExp()+exp);
            System.out.println(exp+"의 경험치를 획득했습니다.\n"+"경험치 :"+dto.getBaseExp()+" / "+dto.getMaxExp());
        }
    }
    PlayerDTO dtoToSkill(){
        return dto;
    }

    boolean levelUp(){
        boolean result=false;
        System.out.println("dto.getBaseExp() = " + dto.getBaseExp());
        System.out.println("dto.getMaxExp() = " + dto.getMaxExp());
        if (dto.getBaseExp() >= dto.getMaxExp()) {
            int baseExp=dto.getBaseExp()-dto.getMaxExp();
            int MaxExp=dto.getMaxExp()*2;
            dto.setStatPoint(5);
            dto.setSkillPoint(1);
            dto.setBaseExp(baseExp);
            dto.setMaxExp(MaxExp);
            dto.setBaseHp(dto.getMaxHp());
            dto.setBaseMp(dto.getMaxMp());
            dto.setLevel(dto.getLevel()+1);
            System.out.println("dto.toString() = " + dto.toString());
            result=true;
        }
        return result;
    }
    void checkStat(){
        System.out.println("==========스텟 포인트==========");
        System.out.println("|공격력 \t\t\t\t\t"+dto.getAtk()+"\t|");
        System.out.println("|마력 \t\t\t\t\t"+dto.getMAtk()+"\t|");
        System.out.println("|방어력 \t\t\t\t\t"+dto.getArmor()+"\t|");
        System.out.println("|크리티컬 확률 \t\t\t"+dto.getCriPercent()+"\t|");
        System.out.println("|크리티컬 데미지 \t\t\t"+dto.getCriDamage()+"\t|");
        System.out.println("|스텟포인트 \t\t\t\t"+dto.getStatPoint()+"\t|");
        System.out.println("=============================");
    }

    String insertStat(int num,int statNum){
        String msg="";

        if(statNum==0){ //사용할 포인트
          msg= "사용할 포인트를 적어주세요";
        }else if(dto.getStatPoint()==0){ //시용할수 있는 포인트
          msg="사용 할수 있는 포인트가 없습니다.";
        } else if (dto.getStatPoint()<statNum) {
            msg="사용하려는 포인트는 보유포인트를 초과할수 없습니다.";
        } else {
            msg="스텟 포인트가 사용되었습니다";
            switch (num) { //1.공격력 ,2.마력 ,3.방어력 ,4.크리티컬 확률 ,5.크리티컬 데미지
                case 1:
                    dto.setAtk(dto.getAtk() + statNum);
                    dto.setStatPoint(dto.getStatPoint()-statNum);
                    break;
                case 2:
                    dto.setMAtk(dto.getMAtk() + statNum);
                    dto.setStatPoint(dto.getStatPoint()-statNum);
                    break;
                case 3:
                    dto.setArmor(dto.getArmor() + statNum);
                    dto.setStatPoint(dto.getStatPoint()-statNum);
                    break;
                case 4:
                    dto.setCriPercent(dto.getCriPercent() + statNum);
                    dto.setStatPoint(dto.getStatPoint()-statNum);
                    break;
                case 5:
                    dto.setCriDamage(dto.getCriDamage() + statNum);
                    dto.setStatPoint(dto.getStatPoint()-statNum);
                    break;
                default:
                    msg="잘못된 선택입니다";
            }
        }
        return msg;
    }

}
