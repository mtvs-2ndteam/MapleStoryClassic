package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.UserView;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class GameController {
    MainView mainView = CONTEXT.getBean("mainView", MainView.class);
    UserView userView = CONTEXT.getBean("userView", UserView.class);

    public void run() {
        mainView.printStartView();
        mainView.printSuccessLoginView();
        while (true) {
            mainView.printMainPage("응", 10, "법사");
            break;
        }
    }
}
