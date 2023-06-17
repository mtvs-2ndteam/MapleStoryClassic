package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.application.controller.SaunaController;
import com.contrabass.mapleclassic.domain.service.GameDomainService;
import org.springframework.stereotype.Service;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service
public class SaunaService {
    SaunaController saunaController = CONTEXT.getBean("saunaController", SaunaController.class);
    GameDomainService gameDomainService = CONTEXT.getBean("gameDomainService", GameDomainService.class);

    // 현재 유저의 메소가 충분한 지 판단
    public void connectPremiumSauna(String mapName, int meso) {
        if (mapName.equals("헤네시스")) {
            saunaController.returnPremiumSauna(gameDomainService.judgeMeso(meso, 1000));
        }
        if (mapName.equals("커닝시티")) {
            saunaController.returnPremiumSauna(gameDomainService.judgeMeso(meso, 2000));
        }
        if (mapName.equals("페리온")) {
            saunaController.returnPremiumSauna(gameDomainService.judgeMeso(meso, 4000));
        }
        if (mapName.equals("엘리니아")) {
            saunaController.returnPremiumSauna(gameDomainService.judgeMeso(meso, 8000));
        }
    }

    public void connectNormalSauna(String mapName, int meso) {
        if (mapName.equals("헤네시스")) {
            saunaController.returnNormalSauna(gameDomainService.judgeMeso(meso, 500));
        }
        if (mapName.equals("커닝시티")) {
            saunaController.returnNormalSauna(gameDomainService.judgeMeso(meso, 1000));
        }
        if (mapName.equals("페리온")) {
            saunaController.returnNormalSauna(gameDomainService.judgeMeso(meso, 2000));
        }
        if (mapName.equals("엘리니아")) {
            saunaController.returnNormalSauna(gameDomainService.judgeMeso(meso, 4000));
        }
    }

    // 사우나 종류에 따른 회복
    public void judgeSauna(int time) {
        gameDomainService.recover(time);
    }
}
