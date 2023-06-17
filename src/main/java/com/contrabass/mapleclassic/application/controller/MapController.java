package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.service.SaunaService;
import com.contrabass.mapleclassic.application.service.ShopService;
import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.MapView;
import com.contrabass.mapleclassic.application.view.SaunaView;
import com.contrabass.mapleclassic.application.view.ShopView;
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
    String mapName = "";

    ///// 헤네시스 (레벨 1 이상 입장 가능) /////
    public void selectHenesys() {
        mapName = "헤네시스";

        mapView.printHenesysMessage();
        while (true) {
            mapView.printHenesys();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 상점
            if (selectNum == 1) {
                selectShop(mapName);
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna(mapName);
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

    ///// 커닝시티 (레벨 11 이상 입장 가능) /////
    public void selectKerningCity() {
        mapName = "커닝시티";

        mapView.printKerningCityMessage();
        while (true) {
            mapView.printKerningCity();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 상점
            if (selectNum == 1) {
                selectShop(mapName);
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna(mapName);
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

    ///// 페리온 (레벨 21 이상 입장 가능) /////
    public void selectPerion() {
        mapName = "페리온";

        mapView.printPerionMessage();
        while (true) {
            mapView.printPerion();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 상점
            if (selectNum == 1) {
                selectShop(mapName);
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna(mapName);
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

    ///// 엘리니아 (레벨 31 이상 입장 가능) /////
    public void selectEllinia() {
        mapName = "엘리니아";

        mapView.printElliniaMessage();
        while (true) {
            mapView.printEllinia();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 상점
            if (selectNum == 1) {
                selectShop(mapName);
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna(mapName);
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
    public void selectShop(String mapName) {
        ShopService shopService = new ShopService();

        shopView.printShopMessage();
        while (true) {
            shopView.printShop();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. HP 물약
            if (selectNum == 1) {
                shopService.connectHpShops(mapName);
                continue;
            }
            // 2. MP 물약
            if (selectNum == 2) {
                shopService.connectMpShops(mapName);
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
    public void selectSauna(String mapName) {
        SaunaService saunaService = new SaunaService();

        saunaView.printSaunaMessage();
        while (true) {
            saunaView.printSauna(mapName);
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 5초 이용
            if (selectNum == 1) {
                saunaService.connectPremiumSauna(mapName, 1000);
                continue;
            }
            // 2. 10초 이용
            if (selectNum == 2) {
                saunaService.connectNormalSauna(mapName, 1000);
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

    public void judgeSauna(String result) {
        if (result.equals("성공")) {

        }
        if (result.equals("실패")) {
            saunaView.printFailMessage();
        }
    }
}
