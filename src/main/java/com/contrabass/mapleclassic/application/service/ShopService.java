package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.application.controller.ShopController;
import com.contrabass.mapleclassic.domain.service.GameDomainService;
import org.springframework.stereotype.Service;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service
public class ShopService {
    ShopController shopController = CONTEXT.getBean("shopController", ShopController.class);
    GameDomainService gameDomainService = CONTEXT.getBean("gameDomainService", GameDomainService.class);


    // 마을 종류에 따른 hp 상점 연결
    public void connectHpShops(String mapName) {
        shopController.selectHpShop(mapName);
    }

    // 마을 종류에 따른 mp 상점 연결
    public void connectMpShops(String mapName) {
        shopController.selectMpShop(mapName);
    }

    // 포션 개수 유효성 검사 로직 연결
    public String inputPotionCount(int count, int meso, String mapName) {
        if (mapName.equals("헤네시스")) {
            return gameDomainService.validatePotionCount(count * 100, meso);
        }
        if (mapName.equals("커닝시티")) {
            return gameDomainService.validatePotionCount(count * 200, meso);
        }
        if (mapName.equals("페리온")) {
            return gameDomainService.validatePotionCount(count * 400, meso);
        }
        if (mapName.equals("엘리니아")) {
            return gameDomainService.validatePotionCount(count * 800, meso);
        }
        return "에러";
    }

}
