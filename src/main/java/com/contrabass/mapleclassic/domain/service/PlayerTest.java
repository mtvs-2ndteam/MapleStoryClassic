package com.contrabass.mapleclassic.domain.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlayerTest {
    public static void main(String[] args) {
        ApplicationContext context1=new AnnotationConfigApplicationContext("com.contrabass.mapleclassic");
        PlayerDAO playerDAO =context1.getBean("plogic", PlayerDAO.class);
        SkillDAO skillDAO=context1.getBean("skillDAO",SkillDAO.class);

        playerDAO.checkStat(); //스탯체크
        playerDAO.testExpUp(140); //경험치를 얻었을때
        playerDAO.checkStat(); //스탯체크
        System.out.println(playerDAO.insertStat(1,3)); //스텟 적용
        playerDAO.checkStat(); //스탯체크
        skillDAO.viewSkill(playerDAO.dtoToSkill()); //스킬체크
        System.out.println(skillDAO.insertSkill(1,1, playerDAO.dtoToSkill()));
        skillDAO.viewSkill(playerDAO.dtoToSkill());


    }
}