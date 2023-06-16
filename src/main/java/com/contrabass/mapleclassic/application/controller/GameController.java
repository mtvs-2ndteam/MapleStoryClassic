package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.UserView;
import com.contrabass.mapleclassic.utils.MainException;
import org.springframework.stereotype.Controller;

import static com.contrabass.mapleclassic.Constant.CONTEXT;
import static com.contrabass.mapleclassic.Constant.SCANNER;

@Controller
public class GameController {
    MapController mapController = CONTEXT.getBean("mapController", MapController.class);
    MainException mainException = CONTEXT.getBean("mainException", MainException.class);
    MainView mainView = CONTEXT.getBean("mainView", MainView.class);
    UserView userView = CONTEXT.getBean("userView", UserView.class);

    ///// 로비 /////
    public void run() {
        mainView.printStartView();
        mainView.printLoginIdView();
        mainView.printLoginPwView();
        mainView.printSuccessLoginView();
        while (true) {
            userView.printUserInfo("뭐함", 10, "마법사");
            mainView.printLobby();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 내 정보
                    selectMyInfo();
                    break;
                case 2: // 마을 이동
                    selectMaps();
                    break;
                case 0: // 게임 종료
                    mainView.printEndMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }

    ///// 내 정보 /////
    public void selectMyInfo() {
        while (true) {
            userView.printSelectMyInfo();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 스텟 찍기
                    break;
                case 0: // 로비
                    mainView.printLobbyMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }

    ///// 마을 이동 /////
    public void selectMaps() {
        while (true) {
            mainView.printMapMovement();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 헤네시스 (레벨 1~10 입장 가능)
                    mapController.selectHenesys();
                    break;
                case 2: // 커닝시티 (레벨 11~20 입장 가능)
                    mapController.selectKerningCity();
                    break;
                case 3: // 페리온 (레벨 21~30 입장 가능)
                    mapController.selectPerion();
                    break;
                case 4: // 엘리니아 (레벨 31~ 입장 가능)
                    mapController.selectEllinia();
                    break;
                case 0: // 로비
                    mainView.printLobbyMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }
}
