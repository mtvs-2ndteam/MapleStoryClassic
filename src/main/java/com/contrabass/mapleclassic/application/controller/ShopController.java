package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.service.ShopService;
import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.ShopView;
import com.contrabass.mapleclassic.utils.MainException;
import org.springframework.stereotype.Controller;

import static com.contrabass.mapleclassic.Constant.CONTEXT;
import static com.contrabass.mapleclassic.Constant.SCANNER;

@Controller
public class ShopController {
    ShopView shopView = CONTEXT.getBean("shopView", ShopView.class);
    MainException mainException = CONTEXT.getBean("mainException", MainException.class);
    MainView mainView = CONTEXT.getBean("mainView", MainView.class);

    ///// HP 포션 컨트롤러 /////
    public void selectHpShop(String mapName) {
        while (true) {
            shopView.printHpPotionMessage();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 구매하기
            if (selectNum == 1) {
                buyPotion(8000, mapName);
                return;
            }
            // 2. 취소
            if (selectNum == 2) {
                mainView.printCancelMessage();
                return;
            }
            // 에러
            mainView.printErrorMessage();
        }
    }

    ///// MP 포션 컨트롤러 /////
    public void selectMpShop(String mapName) {
        while (true) {
            shopView.printMpPotionMessage();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 구매하기
            if (selectNum == 1) {
                buyPotion(8000, mapName);
                return;
            }
            // 2. 취소
            if (selectNum == 2) {
                mainView.printCancelMessage();
                return;
            }
            // 에러
            mainView.printErrorMessage();
        }
    }

    // 포션 구매
    public void buyPotion(int meso, String mapName) {
        ShopService shopService = new ShopService();
        while (true) {
            shopView.printBuyPotion(meso, mapName);
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());
            String result = shopService.inputPotionCount(selectNum, meso, mapName);

            // 구매 성공
            if (result.equals("성공")) {
                shopView.printSuccessMessage();
                return;
            }
            // 실패
            if (result.equals("실패")) {
                shopView.printFailMessage();
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
