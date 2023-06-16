package com.contrabass.mapleclassic.domain.service;

import org.springframework.stereotype.Service;

@Service
public class GameDomainService {

    // 레벨 판단
    public String judgeLevel(int level) {
        if (level < 11) {
            return "헤네시스";
        }
        if (level < 21) {
            return "커닝시티";
        }
        if (level < 31) {
            return "페리온";
        }
        return "엘리니아";
    }
}
