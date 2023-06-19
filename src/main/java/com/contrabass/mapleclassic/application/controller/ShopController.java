package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.service.ShopService;
import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.ShopView;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import org.springframework.stereotype.Controller;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Controller
public class ShopController {
    ShopView shopView = CONTEXT.getBean("shopView", ShopView.class);
    MainView mainView = CONTEXT.getBean("mainView", MainView.class);

    ///// HP 포션 컨트롤러 /////
    public void selectHpShop(PlayerDTO player) {
        while (true) {
            shopView.printHpPotionMessage();
            int selectNum = mainView.input();

            // 1. 구매하기
            if (selectNum == 1) {
                buyPotion(player, "HP");
                return;
            }
            // 2. 판매하기
            if (selectNum == 2) {
                sellPotion(player, "HP");
                return;
            }
            // 0. 취소
            if (selectNum == 0) {
                mainView.printCancelMessage();
                return;
            }
            // 에러
            mainView.printErrorMessage();
        }
    }

    ///// MP 포션 컨트롤러 /////
    public void selectMpShop(PlayerDTO player) {
        while (true) {
            shopView.printMpPotionMessage();
            int selectNum = mainView.input();

            // 1. 구매하기
            if (selectNum == 1) {
                buyPotion(player, "MP");
                return;
            }
            // 2. 판매하기
            if (selectNum == 2) {
                sellPotion(player, "MP");
                return;
            }
            // 0. 취소
            if (selectNum == 0) {
                mainView.printCancelMessage();
                return;
            }
            // 에러
            mainView.printErrorMessage();
        }
    }

    // 포션 구매
    public void buyPotion(PlayerDTO player, String type) {
        ShopService shopService = new ShopService();
        String result = "";

        while (true) {
            shopView.printBuyPotion(player);
            int wantCount = mainView.input();

            // 포션 종류별 계산
            if (type.equals("HP")) {
                result = shopService.buyHpPotionCountService(wantCount, player);
            }
            if (type.equals("MP")) {
                result = shopService.buyMpPotionCountService(wantCount, player);
            }

            // 구매 성공
            if (result.equals("성공")) {
                shopView.printBuySuccessMessage();
                return;
            }
            // 실패
            if (result.equals("실패")) {
                shopView.printBuyFailMessage();
                continue;
            }
            // 취소
            if (result.equals("취소")) {
                mainView.printCancelMessage();
                return;
            }
            // 에러
            mainView.printErrorMessage();
        }
    }

    // 포션 판매
    public void sellPotion(PlayerDTO player, String type) {
        ShopService shopService = new ShopService();
        String result = "";

        while (true) {
            shopView.printSellPotion(player);
            int wantCount = mainView.input();

            // 포션 종류별 계산
            if (type.equals("HP")) {
                result = shopService.sellHpPotionCountService(wantCount, player);
            }
            if (type.equals("MP")) {
                result = shopService.sellMpPotionCountService(wantCount, player);
            }

            // 판매 성공
            if (result.equals("성공")) {
                shopView.printSellSuccessMessage();
                return;
            }
            // 실패
            if (result.equals("실패")) {
                shopView.printSellFailMessage();
                continue;
            }
            // 취소
            if (result.equals("취소")) {
                mainView.printCancelMessage();
                return;
            }
            // 에러
            mainView.printErrorMessage();
        }
    }
}
