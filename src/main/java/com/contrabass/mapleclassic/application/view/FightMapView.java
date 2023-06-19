package com.contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.application.controller.FightController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FightMapView {
    private final FightController fightController;
    private final FightView fightView;
    private boolean run = true;

    @Autowired
    public FightMapView(FightController fightController, FightView fightView) {
        this.fightController = fightController;
        this.fightView = fightView;
    }

    public void selectFightMap(String map) {
        System.out.println("========== 사냥터 목록 ==========");
        System.out.println("1. " + fightController.getCloneMonster(map, 1).getMonsterName() + " 사냥터");
        System.out.println("2. " + fightController.getCloneMonster(map, 2).getMonsterName() + " 사냥터");
        System.out.println("3. " + fightController.getCloneMonster(map, 3).getMonsterName() + " 사냥터");
        System.out.println("4. " + fightController.getCloneMonster(map, 4).getMonsterName() + " 사냥터");
        run = true;
        while (run) {
            switch (new Scanner(System.in).nextLine()) {
                case "1":
                    System.out.println(fightController.getCloneMonster(map, 1).getMonsterName() + "가 나타났다!");
                    fightView.entryFight(fightController.getCloneMonster(map, 1), fightController.getPlayerDTO());
                    run = false;
                    break;
                case "2":
                    System.out.println(fightController.getCloneMonster(map, 2).getMonsterName() + "가 나타났다!");
                    fightView.entryFight(fightController.getCloneMonster(map, 2), fightController.getPlayerDTO());
                    run = false;
                    break;
                case "3":
                    System.out.println(fightController.getCloneMonster(map, 3).getMonsterName() + "가 나타났다!");
                    fightView.entryFight(fightController.getCloneMonster(map, 3), fightController.getPlayerDTO());
                    run = false;
                    break;
                case "4":
                    System.out.println(fightController.getCloneMonster(map, 4).getMonsterName() + "가 나타났다!");
                    fightView.entryFight(fightController.getCloneMonster(map, 4), fightController.getPlayerDTO());
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 값을 입력하였습니다 다시 시도하세요");
                    break;
            }
        }
    }
}
