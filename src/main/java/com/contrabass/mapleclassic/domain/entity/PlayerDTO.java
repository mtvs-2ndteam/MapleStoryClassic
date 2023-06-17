package com.contrabass.mapleclassic.domain.entity;


import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerDTO {
    private String nickName;
    private String job;
    private int hpPotionCount;
    private int mpPotionCount;
    private int level;
    private int baseHp;
    private int baseMp;
    private int maxHp;
    private int maxMp;
    private int armor;
    private int baseExp;
    private int maxExp;
    private int meso;

    private int atk;
    private int mAtk;
    private int criPercent;
    private int criDamage;
    private int statPoint;
    private int skillPoint;

    private ArrayList<SkillDTO> skills;
}


