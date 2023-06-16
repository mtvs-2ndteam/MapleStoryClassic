package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.application.controller.MapController;
import com.contrabass.mapleclassic.domain.service.GameDomainService;
import com.contrabass.mapleclassic.domain.service.UserDomainService;
import org.springframework.stereotype.Service;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service
public class GameService {
    MapController mapController = CONTEXT.getBean("mapController", MapController.class);
    GameDomainService gameDomainService = CONTEXT.getBean("gameDomainService", GameDomainService.class);
    UserDomainService userDomainService = CONTEXT.getBean("userDomainService", UserDomainService.class);

    // 특정 회원 정보 조회
    public void selectOneUser(String userId) {
//        userDomainService.checkUserId(userId);
    }

    // 선택 번호와 레벨에 따른 마을 이동 판단
    public void selectMaps(int selectNum, int level) {
        String jugdeLevel = gameDomainService.judgeLevel(level);

        if ((jugdeLevel.equals("헤네시스")
                || jugdeLevel.equals("커닝시티")
                || jugdeLevel.equals("페리온")
                || jugdeLevel.equals("엘리니아")) && selectNum == 1) {
            mapController.selectHenesys();
        }
        if ((jugdeLevel.equals("커닝시티")
                || jugdeLevel.equals("페리온")
                || jugdeLevel.equals("엘리니아")) && selectNum == 2) {
            mapController.selectKerningCity();
        }
        if ((jugdeLevel.equals("페리온")
                || jugdeLevel.equals("엘리니아")) && selectNum == 3) {
            mapController.selectPerion();
        }
        if (jugdeLevel.equals("엘리니아") && selectNum == 4) {
            mapController.selectEllinia();
        }
        if (jugdeLevel.equals("헤네시스") && selectNum == 2) {
            System.out.println("\n커닝시티는 레벨 11 이상부터 입장 가능합니다.\n");
        }
        if ((jugdeLevel.equals("헤네시스")
                || jugdeLevel.equals("커닝시티")) && selectNum == 3) {
            System.out.println("\n페리온은 레벨 21 이상부터 입장 가능합니다.\n");
        }
        if ((jugdeLevel.equals("헤네시스")
                || jugdeLevel.equals("커닝시티")
                || jugdeLevel.equals("페리온")) && selectNum == 4) {
            System.out.println("\n엘리니아는 레벨 31 이상부터 입장 가능합니다.\n");
        }
    }

}
