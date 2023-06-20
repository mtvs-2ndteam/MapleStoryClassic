package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.dto.SaunaDTO;
import com.contrabass.mapleclassic.application.dto.ShopDTO;
import com.contrabass.mapleclassic.application.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    ///// 레벨 판단 서비스 연결
    public String judgeLevelController(int level) {
        return gameService.judgeLevelService(level);
    }

    ///// 포션 판매 서비스 연결
    public String buyPotionCountController(ShopDTO shopDTO) {
        return gameService.buyPotionCountService(shopDTO);
    }

    ///// HP 포션 판매 서비스 연결
    public String sellPotionCountController(ShopDTO shopDTO) {
        return gameService.sellPotionCountService(shopDTO);
    }

    ///// 프리미엄 / 일반 사우나 서비스 연결
    public String connectSaunaController(SaunaDTO saunaDTO) {
        return gameService.connectSaunaService(saunaDTO);
    }

    ///// 사우나 이용 서비스 연결
    public String goSaunaController(SaunaDTO saunaDTO, int time) {
        return gameService.goSaunaService(saunaDTO, time);
    }

    public String statusSave(int selectNum,int pointNum){return gameService.saveStatus(selectNum,pointNum);}
}
