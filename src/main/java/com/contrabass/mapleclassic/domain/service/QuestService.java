package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.application.dto.NpcQuestDTO;
import com.contrabass.mapleclassic.application.dto.PlayerDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class QuestService {
    private final List<NpcQuestDTO> quests;
    private final PlayerDTO player;

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


