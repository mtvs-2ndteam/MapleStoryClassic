package com.contrabass.mapleclassic.application.controller;

import com.contrabass.mapleclassic.application.service.SaunaService;
import com.contrabass.mapleclassic.application.view.SaunaView;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class SaunaController {
    SaunaView saunaView = CONTEXT.getBean("saunaView", SaunaView.class);

    ///// 프리미엄 사우나 컨트롤러 /////
    public void usePremiumSauna(String result, PlayerDTO player) {
        SaunaService saunaService = new SaunaService();

        // 성공
        if (result.equals("성공")) {
            saunaView.printPremiumSaunaMessage();
            saunaService.goSauna(5, player, "프리미엄");
            saunaView.printSuccessMessage();
            return;
        }
        // 실패
        saunaView.printFailMessage();
    }

    ///// 일반 사우나 컨트롤러 /////
    public void useNormalSauna(String result, PlayerDTO player) {
        SaunaService saunaService = new SaunaService();

        // 성공
        if (result.equals("성공")) {
            saunaView.printNormalSaunaMessage();
            saunaService.goSauna(10, player, "일반");
            saunaView.printSuccessMessage();
            return;
        }
        // 실패
        saunaView.printFailMessage();
    }
}
