package com.contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.domain.entity.PlayerDTO;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class MapView {
    UserView userView = CONTEXT.getBean("userView", UserView.class);

    PlayerDTO player = CONTEXT.getBean("pDTO", PlayerDTO.class);

    public void printSelectMapsMessage() {
        System.out.println("\n마을 선택으로 이동...\n");
    }

    public void printEnterMapMessage(String map) {
        if (map.equals("헤네시스")) {
            System.out.println("\n헤네시스로 이동...\n");
        }
        if (map.equals("커닝시티")) {
            System.out.println("\n커닝시티로 이동...\n");
        }
        if (map.equals("페리온")) {
            System.out.println("\n페리온으로 이동...\n");
        }
        if (map.equals("엘리니아")) {
            System.out.println("\n엘리니아로 이동...\n");
        }
    }

    public void printMenu(String map) {
        if (map.equals("헤네시스")) {
            userView.printUserInfo(player);
            System.out.println("=========== 헤네시스 ==========");
            printSelectMenu();
            System.out.println("4. 자쿰(보스) 이동");
            System.out.println("0. 마을 선택으로 돌아가기");
            System.out.println("메뉴 번호 입력: ");
        }
        if (map.equals("커닝시티")) {
            userView.printUserInfo(player);
            System.out.println("=========== 커닝시티 ==========");
            printSelectMenu();
            System.out.println("4. 핑크빈(보스) 이동");
            System.out.println("0. 마을 선택으로 돌아가기");
            System.out.println("메뉴 번호 입력: ");
        }
        if (map.equals("페리온")) {
            userView.printUserInfo(player);
            System.out.println("=========== 페리온 ==========");
            printSelectMenu();
            System.out.println("4. 루시드(보스) 이동");
            System.out.println("0. 마을 선택으로 돌아가기");
            System.out.println("메뉴 번호 입력: ");
        }
        if (map.equals("엘리니아")) {
            userView.printUserInfo(player);
            System.out.println("=========== 엘리니아 ==========");
            printSelectMenu();
            System.out.println("4. 검은마법사(보스) 이동");
            System.out.println("0. 마을 선택으로 돌아가기");
            System.out.println("메뉴 번호 입력: ");
        }
    }

    public void printSelectMenu() {
        System.out.println("1. 상점");
        System.out.println("2. 사우나");
        System.out.println("3. 사냥터 이동");
    }

    public void printEnterError(String map) {
        if (map.equals("커닝시티")) {
            System.out.println("\n커닝시티는 레벨 11 이상부터 입장 가능합니다.\n");
        }
        if (map.equals("페리온")) {
            System.out.println("\n페리온은 레벨 21 이상부터 입장 가능합니다.\n");
        }
        if (map.equals("엘리니아")) {
            System.out.println("\n엘리니아는 레벨 31 이상부터 입장 가능합니다.\n");
        }
    }
}
