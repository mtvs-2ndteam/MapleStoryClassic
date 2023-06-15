package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.UserView;
import com.contrabass.mapleclassic.utils.MainException;
import org.springframework.stereotype.Controller;

import static com.contrabass.mapleclassic.Constant.CONTEXT;
import static com.contrabass.mapleclassic.Constant.SCANNER;

@Controller
public class GameController {
    MainView mainView = CONTEXT.getBean("mainView", MainView.class);
    MainException mainException = CONTEXT.getBean("mainException", MainException.class);
    UserView userView = CONTEXT.getBean("userView", UserView.class);

    public void run() {
        mainView.printStartView();
        mainView.printLoginIdView();
        mainView.printLoginPwView();
        mainView.printSuccessLoginView();
        while (true) {
            userView.printUserInfo("뭐함", 10, "마법사");
            mainView.printMainPage();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 내 정보
                    break;
                case 2:
                    selectMaps();
                    break;
                case 0:
                    mainView.printEndMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }

    public void selectMaps() {
        while (true) {
            mainView.printMapMovement();
            switch (mainException.solveInputValueException(SCANNER.nextLine())) {
                case 1: // 헤네시스
                    break;
                case 2: // 커닝시티
                    break;
                case 3: // 페리온
                    break;
                case 4: // 엘리니아
                    break;
                case 0:
                    mainView.printBackMessage();
                    return;
                default:
                    mainView.printErrorMessage();
                    break;
            }
        }
    }

}
