package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.service.SaunaService;
import com.contrabass.mapleclassic.application.service.ShopService;
import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.MapView;
import com.contrabass.mapleclassic.application.view.SaunaView;
import com.contrabass.mapleclassic.application.view.ShopView;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.utils.MainException;
import org.springframework.stereotype.Controller;

import static com.contrabass.mapleclassic.Constant.CONTEXT;
import static com.contrabass.mapleclassic.Constant.SCANNER;

@Controller
public class MapController {
    MainException mainException = CONTEXT.getBean("mainException", MainException.class);
    MainView mainView = CONTEXT.getBean("mainView", MainView.class);
    MapView mapView = CONTEXT.getBean("mapView", MapView.class);
    ShopView shopView = CONTEXT.getBean("shopView", ShopView.class);
    SaunaView saunaView = CONTEXT.getBean("saunaView", SaunaView.class);

    ///// 헤네시스 (레벨 1 이상 입장 가능) /////
    ///// 커닝시티 (레벨 11 이상 입장 가능) /////
    ///// 페리온 (레벨 21 이상 입장 가능) /////
    ///// 엘리니아 (레벨 31 이상 입장 가능) /////
    public void selectMap(String map, PlayerDTO player) {
        mapView.printEnterMapMessage(map);
        while (true) {
            mapView.printMenu(map);
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 상점
            if (selectNum == 1) {
                selectShop(player);
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna(player);
                continue;
            }
            // 3. 사냥터
            if (selectNum == 3) {
                continue;
            }
            // 4. 보스
            if (selectNum == 4) {
                continue;
            }
            // 0. 마을 선택으로 돌아가기
            if (selectNum == 0) {
                mainView.printSelectTownMessage();
                return;
            }
            // 에러
            mainView.printErrorMessage();
        }
    }

    ///// 상점 /////
    public void selectShop(PlayerDTO player) {
        ShopService shopService = new ShopService();

        shopView.printShopMessage();
        while (true) {
            shopView.printShop(player);
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. HP 물약
            if (selectNum == 1) {
                shopService.connectHpShops(player);
                continue;
            }
            // 2. MP 물약
            if (selectNum == 2) {
                shopService.connectMpShops(player);
                continue;
            }
            // 0. 마을로 돌아가기
            if (selectNum == 0) {
                mainView.printBackTownMessage();
                return;
            }
            // 에러
            mainView.printErrorMessage();
        }
    }


    ///// 사우나 /////
    public void selectSauna(PlayerDTO player) {
        SaunaService saunaService = new SaunaService();

        saunaView.printSaunaMessage();
        while (true) {
            saunaView.printSauna(player);
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 5초 이용
            if (selectNum == 1) {
                saunaService.connectPremiumSauna(player);
                continue;
            }
            // 2. 10초 이용
            if (selectNum == 2) {
                saunaService.connectNormalSauna(player);
                continue;
            }
            // 0. 마을로 돌아가기
            if (selectNum == 0) {
                mainView.printBackTownMessage();
                return;
            }
            // 에러
            mainView.printErrorMessage();
        }
    }

}
