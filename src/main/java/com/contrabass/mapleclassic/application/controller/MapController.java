package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.MapView;
import com.contrabass.mapleclassic.utils.MainException;
import org.springframework.stereotype.Controller;

import static com.contrabass.mapleclassic.Constant.CONTEXT;
import static com.contrabass.mapleclassic.Constant.SCANNER;

@Controller
public class MapController {
    MainException mainException = CONTEXT.getBean("mainException", MainException.class);
    MainView mainView = CONTEXT.getBean("mainView", MainView.class);
    MapView mapView = CONTEXT.getBean("mapView", MapView.class);

    ///// 헤네시스 (레벨 1 이상 입장 가능) /////
    public void selectHenesys() {
        mapView.printHenesysMessage();
        while (true) {
            mapView.printHenesys();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 상점
            if (selectNum == 1) {
                selectShop();
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna();
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
        mapView.printKerningCityMessage();
        while (true) {
            mapView.printKerningCity();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 상점
            if (selectNum == 1) {
                selectShop();
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna();
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
        mapView.printPerionMessage();
        while (true) {
            mapView.printPerion();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 상점
            if (selectNum == 1) {
                selectShop();
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna();
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
        mapView.printElliniaMessage();
        while (true) {
            mapView.printEllinia();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 상점
            if (selectNum == 1) {
                selectShop();
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna();
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
    public void selectShop() {
        mapView.printShopMessage();
        while (true) {
            mapView.printShop();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. HP 물약
            if (selectNum == 1) {
                continue;
            }
            // 2. MP 물약
            if (selectNum == 2) {
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
    public void selectSauna() {
        mapView.printSaunaMessage();
        while (true) {
            mapView.printSauna();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 5초 이용
            if (selectNum == 1) {
                continue;
            }
            // 2. 10초 이용
            if (selectNum == 2) {
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
