package com.contrabass.mapleclassic.application.view;

public class SaunaView {
    public void printSaunaMessage() {
        System.out.println("\n사우나로 이동...\n");
    }

    public void printSauna(String mapName) {
        System.out.println("========== 사우나 ==========");
        printBuySauna(mapName);
        System.out.println("0. 마을로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printBuySauna(String mapName) {
        if (mapName.equals("헤네시스")) {
            System.out.println("1. 프리미엄 사우나 (5초 / 1000 메소)");
            System.out.println("2. 일반 사우나 (10초 / 500 메소)");
        }
        if (mapName.equals("커닝시티")) {
            System.out.println("1. 프리미엄 사우나 (5초 / 2000 메소)");
            System.out.println("2. 일반 사우나 (10초 / 1000 메소)");
        }
        if (mapName.equals("페리온")) {
            System.out.println("1. 프리미엄 사우나 (5초 / 4000 메소)");
            System.out.println("2. 일반 사우나 (10초 / 2000 메소)");
        }
        if (mapName.equals("엘리니아")) {
            System.out.println("1. 프리미엄 사우나 (5초 / 8000 메소)");
            System.out.println("2. 일반 사우나 (10초 / 4000 메소)");
        }
    }

    public void printPremiumSaunaMessage() {
        System.out.println("\n=== 프리미엄 사우나 ===\n");
        System.out.println("회복 중입니다...(5초)");
    }

    public void printNormalSaunaMessage() {
        System.out.println("\n=== 일반 사우나 ===\n");
        System.out.println("회복 중입니다...(10초)");
    }

    public void printSuccessMessage() {
        System.out.println("\nHP/MP 전체 회복!\n");
    }

    public void printFailMessage() {
        System.out.println("\n메소가 부족합니다...\n");
    }
}
