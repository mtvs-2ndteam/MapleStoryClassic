package com.contrabass.mapleclassic.application.view;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class MapView {
    UserView userView = CONTEXT.getBean("userView", UserView.class);
    int userLevel = 11; // 유저 정보 불러오는 메소드 써야함

    public void printSelectMapsMessage() {
        System.out.println("\n마을 선택으로 이동...\n");
    }

    public void printHenesysMessage() {
        System.out.println("\n헤네시스로 이동...\n");
    }

    public void printKerningCityMessage() {
        System.out.println("\n커닝시티로 이동...\n");
    }

    public void printPerionMessage() {
        System.out.println("\n페리온으로 이동...\n");
    }

    public void printElliniaMessage() {
        System.out.println("\n엘리니아로 이동...\n");
    }

    public void printShopMessage() {
        System.out.println("\n상점으로 이동...\n");
    }

    public void printSaunaMessage() {
        System.out.println("\n사우나로 이동...\n");
    }

    public void printHenesys() {
        userView.printUserInfo("뭐함", userLevel, "마법사");
        System.out.println("=========== 헤네시스 ==========");
        printSelectMenu();
        System.out.println("4. 자쿰(보스) 이동");
        System.out.println("0. 마을 선택으로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printKerningCity() {
        userView.printUserInfo("뭐함", userLevel, "마법사");
        System.out.println("=========== 커닝시티 ==========");
        printSelectMenu();
        System.out.println("4. 핑크빈(보스) 이동");
        System.out.println("0. 마을 선택으로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printPerion() {
        userView.printUserInfo("뭐함", userLevel, "마법사");
        System.out.println("=========== 페리온 ==========");
        printSelectMenu();
        System.out.println("4. 루시드(보스) 이동");
        System.out.println("0. 마을 선택으로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printEllinia() {
        userView.printUserInfo("뭐함", userLevel, "마법사");
        System.out.println("=========== 엘리니아 ==========");
        printSelectMenu();
        System.out.println("4. 검은마법사(보스) 이동");
        System.out.println("0. 마을 선택으로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printSelectMenu() {
        System.out.println("1. 상점");
        System.out.println("2. 사우나");
        System.out.println("3. 사냥터 이동");
    }

    public void printShop() {
        System.out.println("=========== 상점 ==========");
        System.out.println("1. HP 포션 구매");
        System.out.println("2. MP 포션 구매");
        System.out.println("0. 마을로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printSauna() {
        System.out.println("========== 사우나 ==========");
        System.out.println("1. 5초 이용 시 전체 회복 (1000메소)");
        System.out.println("2. 10초 이용 시 전체 회복 (500메소)");
        System.out.println("0. 마을로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printKerningCityError() {
        System.out.println("\n커닝시티는 레벨 11 이상부터 입장 가능합니다.\n");
    }

    public void printPerionError() {
        System.out.println("\n페리온은 레벨 21 이상부터 입장 가능합니다.\n");
    }

    public void printElliniaError() {
        System.out.println("\n엘리니아는 레벨 31 이상부터 입장 가능합니다.\n");
    }
}
