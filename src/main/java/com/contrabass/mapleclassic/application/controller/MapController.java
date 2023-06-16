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

    ///// 헤네시스 (레벨 1~10 입장 가능) /////
    public void selectHenesys() {
        while (true) {
            mapView.printHenesys();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 상점
                    selectShop();
                    break;
                case 2: // 사우나
                    selectSauna();
                    break;
                case 3: // 사냥터
                    break;
                case 4: // 보스
                    break;
                case 0: // 뒤로 가기
                    mainView.printBackMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }

    ///// 커닝시티 (레벨 11~20 입장 가능) /////
    public void selectKerningCity() {
        while (true) {
            mapView.printKerningCity();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 상점
                    selectShop();
                    break;
                case 2: // 사우나
                    selectSauna();
                    break;
                case 3: // 사냥터
                    break;
                case 4: // 보스
                    break;
                case 0: // 뒤로 가기
                    mainView.printBackMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }

    ///// 페리온 (레벨 21~30 입장 가능) /////
    public void selectPerion() {
        while (true) {
            mapView.printPerion();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 상점
                    selectShop();
                    break;
                case 2: // 사우나
                    selectSauna();
                    break;
                case 3: // 사냥터
                    break;
                case 4: // 보스
                    break;
                case 0: // 뒤로 가기
                    mainView.printBackMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }

    ///// 엘리니아 (레벨 31~ 입장 가능) /////
    public void selectEllinia() {
        while (true) {
            mapView.printEllinia();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 상점
                    selectShop();
                    break;
                case 2: // 사우나
                    selectSauna();
                    break;
                case 3: // 사냥터
                    break;
                case 4: // 보스
                    break;
                case 0: // 뒤로 가기
                    mainView.printBackMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }

    ///// 상점 /////
    public void selectShop() {
        while (true) {
            mapView.printShop();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // HP 포션
                    break;
                case 2: // MP 포션
                    break;
                case 0: // 뒤로 가기
                    mainView.printBackMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }

    ///// 사우나 /////
    public void selectSauna() {
        while (true) {
            mapView.printSauna();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 5초 이용
                    break;
                case 2: // 10초 이용
                    break;
                case 0: // 뒤로 가기
                    mainView.printBackMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }
}
