package com.contrabass.mapleclassic.domain.service;

import com.contrabass.mapleclassic.application.dto.SaunaDTO;
import com.contrabass.mapleclassic.application.dto.ShopDTO;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
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

    // 포션 구매
    public String buyPotionCount(ShopDTO shopDTO, int price) {
        // HP 포션 구매
        if (shopDTO.getWantCount() > 0
                && shopDTO.getWantCount() * price <= shopDTO.getPlayer().getMeso()
                && shopDTO.getType().equals("HP")) {
            shopDTO.getPlayer().setMeso(shopDTO.getPlayer().getMeso() - shopDTO.getWantCount() * price);
            shopDTO.getPlayer().setHpPotionCount(shopDTO.getPlayer().getHpPotionCount() + shopDTO.getWantCount());
            return "성공";
        }
        // MP 포션 구매
        if (shopDTO.getWantCount() > 0
                && shopDTO.getWantCount() * price <= shopDTO.getPlayer().getMeso()
                && shopDTO.getType().equals("MP")) {
            shopDTO.getPlayer().setMeso(shopDTO.getPlayer().getMeso() - shopDTO.getWantCount() * price);
            shopDTO.getPlayer().setMpPotionCount(shopDTO.getPlayer().getMpPotionCount() + shopDTO.getWantCount());
            return "성공";
        }
        // 취소
        if (shopDTO.getWantCount() == 0) {
            return "취소";
        }
        // 메소 부족
        return "실패";
    }


    // 포션 판매
    public String sellPotionCount(ShopDTO shopDTO, int price) {
        // HP 포션 판매
        if (shopDTO.getWantCount() > 0
                && shopDTO.getWantCount() <= shopDTO.getPlayer().getHpPotionCount()
                && shopDTO.getType().equals("HP")) {
            shopDTO.getPlayer().setMeso(shopDTO.getPlayer().getMeso() + shopDTO.getWantCount() * price);
            shopDTO.getPlayer().setHpPotionCount(shopDTO.getPlayer().getHpPotionCount() - shopDTO.getWantCount());
            return "성공";
        }
        // MP 포션 판매
        if (shopDTO.getWantCount() > 0
                && shopDTO.getWantCount() <= shopDTO.getPlayer().getMpPotionCount()
                && shopDTO.getType().equals("MP")) {
            shopDTO.getPlayer().setMeso(shopDTO.getPlayer().getMeso() + shopDTO.getWantCount() * price);
            shopDTO.getPlayer().setMpPotionCount(shopDTO.getPlayer().getMpPotionCount() - shopDTO.getWantCount());
            return "성공";
        }
        // 취소
        if (shopDTO.getWantCount() == 0) {
            return "취소";
        }
        // 메소 부족
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
    public String recover(SaunaDTO saunaDTO, int time, int standard) {
        try {
            saunaDTO.getPlayer().setMeso(saunaDTO.getPlayer().getMeso() - standard);
            saunaDTO.getPlayer().setBaseHp(saunaDTO.getPlayer().getMaxHp());
            saunaDTO.getPlayer().setBaseMp(saunaDTO.getPlayer().getMaxMp());
            TimeUnit.SECONDS.sleep(time);
            return "성공";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "실패";
    }
}
