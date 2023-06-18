package com.contrabass.mapleclassic.domain.entity;

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

    public int monsterHitDamage = 0;
    public int playerHitDamage = 0;
}
