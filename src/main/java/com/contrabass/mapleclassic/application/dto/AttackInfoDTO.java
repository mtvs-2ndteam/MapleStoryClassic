package com.contrabass.mapleclassic.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttackInfoDTO {
    public boolean isPlayerDie = false;
    public boolean isMonsterDie = false;

    private int monsterHitDamage = 0;
    private int playerHitDamage = 0;
}
