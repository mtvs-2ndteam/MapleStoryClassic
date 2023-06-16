package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.entity.SkillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service("skillDAO")
public class SkillDAO {
    private Map<Integer, SkillDTO> skillList;
    @Autowired
    public SkillDAO() {
        this.skillList=new HashMap<>();
        skillList.put(1,new SkillDTO(20,"에너지볼트",1,10));
        skillList.put(2,new SkillDTO(25,"콜드 빔",1,15));
        skillList.put(3,new SkillDTO(30,"썬더 볼트",1,20));
        skillList.put(4,new SkillDTO(40,"파이어 월",1,30));
    }

    public ArrayList<SkillDTO> viewSkill(PlayerDTO dto){
        System.out.println("=======================스킬 포인트=======================");
        for(SkillDTO skill:dto.getSkills()){
            System.out.println("|"+skill.getSkillName()+":\t데미지 :\t"+
                    skill.getSkillDmg()+"\t마나소모량 :"+
                    skill.getUseMp()+"\t스킬레벨 :\t"+
                    skill.getSkillLevel()+"|");
        }
        System.out.println("=======================================================");
        return new ArrayList<>(skillList.values());
    }

    String insertSkill(int num, int statNum,PlayerDTO dto){
        String msg="";
        if(statNum==0){ //사용할 포인트
            msg= "사용 할 포인트를 입력 해 주세요";
        }else if(dto.getStatPoint()==0){ //시용할수 있는 포인트
            msg="사용 할수 있는 포인트 부족합니다.";
        }else {
            msg="스킬포인트가 사용되었습니다";
            SkillDTO skillDTO;
            if (num-1>=0&&num-1<=3){
                skillDTO=dto.getSkills().get(num-1);
                skillDTO.setSkillLevel(skillDTO.getSkillLevel()+statNum);
                skillDTO.setSkillDmg(skillDTO.getSkillDmg()+skillDTO.getSkillLevel()*5);
                dto.getSkills().set(num-1,skillDTO);
            }else msg="잘못된 숫자입니다.";

        }
        return msg;
    }

    public Map<Integer, SkillDTO> getSkillList() {
        return skillList;
    }

    public void setSkillList(Map<Integer, SkillDTO> skillList) {
        this.skillList = skillList;
    }
}
