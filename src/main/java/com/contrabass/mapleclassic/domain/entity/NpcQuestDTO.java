package com.contrabass.mapleclassic.domain.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NpcQuestDTO {

    private String QuestName;
    private Boolean complete;
    private int monsterCount;
    private Boolean changeJob;
}
