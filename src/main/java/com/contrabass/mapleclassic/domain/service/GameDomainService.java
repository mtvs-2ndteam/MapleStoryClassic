package com.contrabass.mapleclassic.domain.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

    // 포션 개수 유효성 검사
    public String validatePotionCount(int count, int meso) {
        if (count == 0) {
            return "취소";
        }
        if (count > 0 && count <= meso) {
            return "성공";
        }
        return "실패";
    }

    public String judgeMeso(int meso, int standard) {
        if (meso >= standard) {
            return "성공";
        }
        return "실패";
    }

    public void recover(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
