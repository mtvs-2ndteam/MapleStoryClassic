package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.service.GameService;
import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.MapView;
import com.contrabass.mapleclassic.application.view.UserView;
import com.contrabass.mapleclassic.utils.MainException;
import org.springframework.stereotype.Controller;

import static com.contrabass.mapleclassic.Constant.CONTEXT;
import static com.contrabass.mapleclassic.Constant.SCANNER;

@Controller
public class GameController {
    MainException mainException = CONTEXT.getBean("mainException", MainException.class);
    GameService gameService = CONTEXT.getBean("gameService", GameService.class);
    MainView mainView = CONTEXT.getBean("mainView", MainView.class);
    MapView mapView = CONTEXT.getBean("mapView", MapView.class);
    UserView userView = CONTEXT.getBean("userView", UserView.class);
    int userLevel = 11; // 유저 정보 불러오는 메소드 써야함

    ///// 로비 /////
    public void run() {
        mainView.printStartView();
        mainView.printLoginIdView();
        mainView.printLoginPwView();
        mainView.printSuccessLoginView();
        while (true) {
            userView.printUserInfo("뭐함", userLevel, "마법사");
            mainView.printLobby();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 내 정보
            if (selectNum == 1) {
                selectMyInfo();
            }
            // 2. 마을 이동
            if (selectNum == 2) {
                selectMaps();
            }
            // 0. 게임 종료
            if (selectNum == 0) {
                mainView.printEndMessage();
                return;
            }
            // 에러
            if (selectNum == -1) {
                mainView.printErrorMessage();
            }
        }
    }

    ///// 내 정보 /////
    public void selectMyInfo() {
        userView.printMyInfoMessage();
        while (true) {
            userView.printSelectMyInfo();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 스텟 찍기
            if (selectNum == 1) {
                continue;
            }
            // 0. 로비
            if (selectNum == 0) {
                mainView.printLobbyMessage();
                return;
            }
            // 에러
            if (selectNum == -1) {
                mainView.printErrorMessage();
            }
        }
    }

    ///// 마을 이동 /////
    public void selectMaps() {
        mapView.printSelectMapsMessage();
        while (true) {
            mainView.printMapMovement();
            int selectNum = mainException.solveInputValueException(SCANNER.nextLine());

            // 1. 헤네시스(레벨 1 이상 입장 가능)
            // 2. 커닝시티(레벨 11 이상 입장 가능)
            // 3. 페리온(레벨 21 이상 입장 가능)
            // 4. 엘리니아(레벨 31 이상 입장 가능)
            if (selectNum == 1
                    || selectNum == 2
                    || selectNum == 3
                    || selectNum == 4) {
                gameService.selectMaps(selectNum, userLevel);
                continue;
            }

            // 0. 로비
            if (selectNum == 0) {
                mainView.printLobbyMessage();
                return;
            }
            // 에러
            if (selectNum == -1) {
                mainView.printErrorMessage();
            }
        }
    }
}
