package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
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

    // Hp 포션 구매
    public String buyHpPotionCount(int wantCount, PlayerDTO player, int price) {
        if (wantCount == 0) {
            return "취소";
        }
        if (wantCount > 0 && wantCount * price <= player.getMeso()) {
            player.setMeso(player.getMeso() - wantCount * price);
            player.setHpPotionCount(player.getHpPotionCount() + wantCount);
            return "성공";
        }
        return "실패";
    }

    // Mp 포션 구매
    public String buyMpPotionCount(int wantCount, PlayerDTO player, int price) {
        if (wantCount == 0) {
            return "취소";
        }
        if (wantCount > 0 && wantCount * price <= player.getMeso()) {
            player.setMeso(player.getMeso() - wantCount * price);
            player.setMpPotionCount(player.getMpPotionCount() + wantCount);
            return "성공";
        }
        return "실패";
    }

    // Hp 포션 판매
    public String sellHpPotionCount(int wantCount, PlayerDTO player, int price) {
        if (wantCount == 0) {
            return "취소";
        }
        if (wantCount > 0 && wantCount <= player.getHpPotionCount()) {
            player.setMeso(player.getMeso() + wantCount * price);
            player.setHpPotionCount(player.getHpPotionCount() - wantCount);
            return "성공";
        }
        return "실패";
    }

    // Mp 포션 판매
    public String sellMpPotionCount(int wantCount, PlayerDTO player, int price) {
        if (wantCount == 0) {
            return "취소";
        }
        if (wantCount > 0 && wantCount <= player.getMpPotionCount()) {
            player.setMeso(player.getMeso() + wantCount * price);
            player.setMpPotionCount(player.getMpPotionCount() - wantCount);
            return "성공";
        }
        return "실패";
    }

    // 메소 부족 판단
    public String judgeMeso(int meso, int standard) {
        if (meso >= standard) {
            return "성공";
        }
        return "실패";
    }

    // 사우나 종류에 따른 회복 시간 판단
    public String recover(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
            return "성공";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "실패";
    }
}
