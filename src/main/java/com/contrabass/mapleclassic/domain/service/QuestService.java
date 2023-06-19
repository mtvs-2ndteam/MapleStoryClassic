package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.entity.NpcQuestDTO;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Component
public class QuestService {
    private List<NpcQuestDTO> quests;
    private PlayerDTO player;

    public QuestService(PlayerDTO player) {
        this.quests = new ArrayList<>();
        this.player = player;
    }

    public void addQuest(NpcQuestDTO npcQuest) {
        quests.add(npcQuest);
    }

    public void completeQuest(NpcQuestDTO npcQuest) {
        
    }
}


