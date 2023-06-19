package com.contrabass.mapleclassic.application.dto;


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
