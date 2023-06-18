package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.application.controller.ShopController;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.service.GameDomainService;
import org.springframework.stereotype.Service;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service
public class ShopService {
    ShopController shopController = CONTEXT.getBean("shopController", ShopController.class);
    GameDomainService gameDomainService = CONTEXT.getBean("gameDomainService", GameDomainService.class);


    // HP 상점 연결
    public void connectHpShops(PlayerDTO player) {
        shopController.selectHpShop(player);
    }

    // MP 상점 연결
    public void connectMpShops(PlayerDTO player) {
        shopController.selectMpShop(player);
    }

    // HP 포션 구매 로직 연결
    public String buyHpPotionCountService(int wantCount, PlayerDTO player) {
        if (player.getLevel() > 0 && player.getLevel() < 11) {
            return gameDomainService.buyHpPotionCount(wantCount, player, 100);
        }
        if (player.getLevel() > 10 && player.getLevel() < 21) {
            return gameDomainService.buyHpPotionCount(wantCount, player, 200);
        }
        if (player.getLevel() > 20 && player.getLevel() < 31) {
            return gameDomainService.buyHpPotionCount(wantCount, player, 400);
        }
        if (player.getLevel() > 30) {
            return gameDomainService.buyHpPotionCount(wantCount, player, 800);
        }
        return "에러";
    }

    // MP 포션 구매 로직 연결
    public String buyMpPotionCountService(int wantCount, PlayerDTO player) {
        if (player.getLevel() > 0 && player.getLevel() < 11) {
            return gameDomainService.buyMpPotionCount(wantCount, player, 100);
        }
        if (player.getLevel() > 10 && player.getLevel() < 21) {
            return gameDomainService.buyMpPotionCount(wantCount, player, 200);
        }
        if (player.getLevel() > 20 && player.getLevel() < 31) {
            return gameDomainService.buyMpPotionCount(wantCount, player, 400);
        }
        if (player.getLevel() > 30) {
            return gameDomainService.buyMpPotionCount(wantCount, player, 800);
        }
        return "에러";
    }

    // HP 포션 판매 로직 연결
    public String sellHpPotionCountService(int wantCount, PlayerDTO player) {
        if (player.getLevel() > 0 && player.getLevel() < 11) {
            return gameDomainService.sellHpPotionCount(wantCount, player, 70);
        }
        if (player.getLevel() > 10 && player.getLevel() < 21) {
            return gameDomainService.sellHpPotionCount(wantCount, player, 140);
        }
        if (player.getLevel() > 20 && player.getLevel() < 31) {
            return gameDomainService.sellHpPotionCount(wantCount, player, 280);
        }
        if (player.getLevel() > 30) {
            return gameDomainService.sellHpPotionCount(wantCount, player, 560);
        }
        return "에러";
    }

    // MP 포션 판매 로직 연결
    public String sellMpPotionCountService(int wantCount, PlayerDTO player) {
        if (player.getLevel() > 0 && player.getLevel() < 11) {
            return gameDomainService.sellMpPotionCount(wantCount, player, 70);
        }
        if (player.getLevel() > 10 && player.getLevel() < 21) {
            return gameDomainService.sellMpPotionCount(wantCount, player, 140);
        }
        if (player.getLevel() > 20 && player.getLevel() < 31) {
            return gameDomainService.sellMpPotionCount(wantCount, player, 280);
        }
        if (player.getLevel() > 30) {
            return gameDomainService.sellMpPotionCount(wantCount, player, 560);
        }
        return "에러";
    }

}
