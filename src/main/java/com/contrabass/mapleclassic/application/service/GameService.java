package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.application.dto.SaunaDTO;
import com.contrabass.mapleclassic.application.dto.ShopDTO;
import com.contrabass.mapleclassic.domain.service.GameDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameDomainService gameDomainService;

    @Autowired
    public GameService(GameDomainService gameDomainService) {
        this.gameDomainService = gameDomainService;
    }


    // 특정 회원 정보 조회
    public void selectOneUser(String userId) {
//        userDomainService.checkUserId(userId);
    }

    // 레벨 판단 도메인 로직 연결
    public String judgeLevelService(int level) {
        return gameDomainService.judgeLevel(level);
    }

    // 포션 가격 기준
    public int price(ShopDTO shopDTO, String type) {
        double price = 0;
        double penalty = 1;
        if (type.equals("판매")) {
            penalty = 0.7;
        }

        if (shopDTO.getPlayer().getLevel() > 0 && shopDTO.getPlayer().getLevel() < 11) {
            price = (100 * penalty);
        }
        if (shopDTO.getPlayer().getLevel() > 10 && shopDTO.getPlayer().getLevel() < 21) {
            price = (200 * penalty);
        }
        if (shopDTO.getPlayer().getLevel() > 20 && shopDTO.getPlayer().getLevel() < 31) {
            price = (400 * penalty);
        }
        if (shopDTO.getPlayer().getLevel() > 30) {
            price = (800 * penalty);
        }
        return (int) price;
    }

    // 포션 구매 도메인 로직 연결
    public String buyPotionCountService(ShopDTO shopDTO) {
        return gameDomainService.buyPotionCount(shopDTO, price(shopDTO, "구매"));
    }

    // 포션 판매 도메인 로직 연결
    public String sellPotionCountService(ShopDTO shopDTO) {
        return gameDomainService.sellPotionCount(shopDTO, price(shopDTO, "판매"));
    }

    // 사우나 가격표 기준
    public int standard(SaunaDTO saunaDTO) {
        int standard = 0;
        int royalty = 1;
        if (saunaDTO.getType().equals("프리미엄")) {
            royalty = 2;
        }
        if (saunaDTO.getPlayer().getLevel() > 0 && saunaDTO.getPlayer().getLevel() < 11) {
            standard = 500 * royalty;
        }
        if (saunaDTO.getPlayer().getLevel() > 10 && saunaDTO.getPlayer().getLevel() < 21) {
            standard = 1000 * royalty;
        }
        if (saunaDTO.getPlayer().getLevel() > 20 && saunaDTO.getPlayer().getLevel() < 31) {
            standard = 2000 * royalty;
        }
        if (saunaDTO.getPlayer().getLevel() > 30) {
            standard = 4000 * royalty;
        }
        return standard;
    }

    // 메소 판단 도메인 로직 연결
    public String connectSaunaService(SaunaDTO saunaDTO) {
        return gameDomainService.judgeMeso(saunaDTO.getPlayer().getMeso(), standard(saunaDTO));
    }

    // 사우나 종류에 따른 회복 도메인 로직 연결
    public String goSaunaService(SaunaDTO saunaDTO, int time) {
        return gameDomainService.recover(saunaDTO, time, standard(saunaDTO));
    }


}
