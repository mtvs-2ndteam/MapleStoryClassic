package com.contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.domain.entity.PlayerDTO;

public class SaunaView {
    public void printSaunaMessage() {
        System.out.println("\n사우나로 이동...\n");
    }

    public void printSauna(PlayerDTO player) {
        System.out.println("========== 사우나 ==========");
        System.out.println(player.getNickName() + "  Lv." + player.getLevel() + "  메소: " + player.getMeso());
        System.out.println("HP: " + player.getBaseHp() + "/" + player.getMaxHp()
                + "  MP: " + player.getBaseMp() + "/" + player.getMaxMp());
        System.out.println("\n== 가격표 ==");
        System.out.println("Lv.1~10 : 프리미엄 1000메소 / 일반 500메소" +
                "\nLv.11~20 : 프리미엄 2000메소 / 일반 1000메소" +
                "\nLv.21~30 : 프리미엄 4000메소 / 일반 2000메소" +
                "\nLv.31~ : 프리미엄 8000메소 / 일반 4000메소");
        System.out.println("1. 프리미엄 사우나 (5초)");
        System.out.println("2. 일반 사우나 (10초)");
        System.out.println("0. 마을로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
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
