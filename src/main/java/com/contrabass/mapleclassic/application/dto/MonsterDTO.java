package com.contrabass.mapleclassic.application.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonsterDTO {

    String monsterName;
    int monsterLevel;
    int monsterHp;
    int monsterPower;
    int monsterDropMoney;
    int exp;
}
