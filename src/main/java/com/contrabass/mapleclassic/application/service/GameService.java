package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.application.controller.MapController;
import com.contrabass.mapleclassic.application.view.MapView;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.service.GameDomainService;
import com.contrabass.mapleclassic.domain.service.UserDomainService;
import org.springframework.stereotype.Service;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service
public class GameService {
    MapView mapView = CONTEXT.getBean("mapView", MapView.class);
    MapController mapController = CONTEXT.getBean("mapController", MapController.class);
    GameDomainService gameDomainService = CONTEXT.getBean("gameDomainService", GameDomainService.class);
    UserDomainService userDomainService = CONTEXT.getBean("userDomainService", UserDomainService.class);

    // 특정 회원 정보 조회
    public void selectOneUser(String userId) {
//        userDomainService.checkUserId(userId);
    }

    // 선택 번호와 레벨에 따른 마을 이동 판단
    public void selectMaps(int selectNum, PlayerDTO player) {
        String judgeLevel = gameDomainService.judgeLevel(player.getLevel());
        String map = "";

        // 정상 입장
        if ((judgeLevel.equals("헤네시스")
                || judgeLevel.equals("커닝시티")
                || judgeLevel.equals("페리온")
                || judgeLevel.equals("엘리니아")) && selectNum == 1) {
            mapController.selectMap("헤네시스", player);
        }
        if ((judgeLevel.equals("커닝시티")
                || judgeLevel.equals("페리온")
                || judgeLevel.equals("엘리니아")) && selectNum == 2) {
            mapController.selectMap("커닝시티", player);
        }
        if ((judgeLevel.equals("페리온")
                || judgeLevel.equals("엘리니아")) && selectNum == 3) {
            mapController.selectMap("페리온", player);
        }
        if (judgeLevel.equals("엘리니아") && selectNum == 4) {
            mapController.selectMap("엘리니아", player);
        }

        // 잘못된 입장
        if (judgeLevel.equals("헤네시스") && selectNum == 2) {
            mapView.printEnterError("커닝시티");
        }
        if ((judgeLevel.equals("헤네시스")
                || judgeLevel.equals("커닝시티")) && selectNum == 3) {
            mapView.printEnterError("페리온");
        }
        if ((judgeLevel.equals("헤네시스")
                || judgeLevel.equals("커닝시티")
                || judgeLevel.equals("페리온")) && selectNum == 4) {
            mapView.printEnterError("엘리니아");
        }
    }
    public void selectJob(int selectNum) {

        if(selectNum == 1) {
            mapController.selectJob();
        }
        if(selectNum == 2) {
            mapController.selectJob();
        }
        if(selectNum == 3) {
            mapController.selectJob();
        }
        if(selectNum == 4) {
            mapController.selectJob();
        }
    }


}
