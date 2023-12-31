package com.contrabass.mapleclassic.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CloneMonsterDTO {
    String monsterName;
    int monsterLevel;
    int monsterHp;
    int monsterPower;
    int monsterDropMoney;
    int exp;
}
