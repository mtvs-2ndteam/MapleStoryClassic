package com.contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.application.controller.FightController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.contrabass.mapleclassic.Constant.SCANNER;

@Component
public class FightMapView {
    private boolean run = true;

    private final FightController fightController;
    private final FightView fightView;

    @Autowired
    public FightMapView(FightController fightController, FightView fightView) {
        this.fightController = fightController;
        this.fightView = fightView;
    }

    public void selectFightMap() {
        System.out.println("========== 사냥터 목록 ==========");
        System.out.println("1. 사냥터 1");
        System.out.println("2. 사냥터 2");
        System.out.println("3. 사냥터 3");
        System.out.println("4. 사냥터 4");
        run = true;
        while(run){
            switch (SCANNER.nextLine()) {
                case "1":
                    fightController.getCloneMonster("henesys", 1);
                    fightView.entryFight(fightController.getCloneMonster("henesys", 1), fightController.getPlayerDTO());
                    run = false;
                    break;
                case "2":
                    fightController.getCloneMonster("henesys", 2);
                    fightView.entryFight(fightController.getCloneMonster("henesys", 2), fightController.getPlayerDTO());
                    run = false;
                    break;
                case "3":
                    fightController.getCloneMonster("henesys", 3);
                    fightView.entryFight(fightController.getCloneMonster("henesys", 3), fightController.getPlayerDTO());
                    run = false;
                    break;
                case "4":
                    fightController.getCloneMonster("henesys", 4);
                    fightView.entryFight(fightController.getCloneMonster("henesys", 4), fightController.getPlayerDTO());
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 값을 입력하였습니다 다시 시도하세요");
                    break;
            }
        }
    }
}
