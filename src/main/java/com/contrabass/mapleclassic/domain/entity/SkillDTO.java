package com.contrabass.mapleclassic.domain.entity;


import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkillDTO {
    int skillDmg;
    String skillName;
    int skillLevel;
    int useMp;
}
