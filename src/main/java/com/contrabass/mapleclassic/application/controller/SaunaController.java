package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.service.SaunaService;
import com.contrabass.mapleclassic.application.view.MainView;
import com.contrabass.mapleclassic.application.view.SaunaView;
import com.contrabass.mapleclassic.utils.MainException;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class SaunaController {
    SaunaView saunaView = CONTEXT.getBean("saunaView", SaunaView.class);
    MainException mainException = CONTEXT.getBean("mainException", MainException.class);
    MainView mainView = CONTEXT.getBean("mainView", MainView.class);

    ///// 프리미엄 사우나 컨트롤러 /////
    public void returnPremiumSauna(String result) {
        SaunaService saunaService = new SaunaService();
        // 성공
        if (result.equals("성공")) {
            saunaView.printPremiumSaunaMessage();
            saunaService.judgeSauna(5);
            saunaView.printSuccessMessage();
            return;
        }
        // 실패
        saunaView.printFailMessage();
    }

    ///// 일반 사우나 컨트롤러 /////
    public void returnNormalSauna(String result) {
        SaunaService saunaService = new SaunaService();
        // 성공
        if (result.equals("성공")) {
            saunaView.printNormalSaunaMessage();
            saunaService.judgeSauna(10);
            saunaView.printSuccessMessage();
            return;
        }
        // 실패
        saunaView.printFailMessage();
    }
}
