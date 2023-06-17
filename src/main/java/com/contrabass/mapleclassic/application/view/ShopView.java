package com.contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.domain.entity.PlayerDTO;

public class ShopView {
    public void printShopMessage() {
        System.out.println("\n상점으로 이동...\n");
    }

    public void printHpPotionMessage() {
        System.out.println("\n=== HP 포션 === \n1. 구매하기\n2. 판매하기\n0. 취소");
    }

    public void printMpPotionMessage() {
        System.out.println("\n=== MP 포션 === \n1. 구매하기\n2. 판매하기\n0. 취소");
    }

    public void printBuySuccessMessage() {
        System.out.println("\n구매 성공!\n");
    }

    public void printSellSuccessMessage() {
        System.out.println("\n판매 성공!\n");
    }

    public void printBuyFailMessage() {
        System.out.println("\n구매 실패...\n");
    }

    public void printSellFailMessage() {
        System.out.println("\n판매 실패...\n");
    }

    public void printStatus(PlayerDTO player) {
        System.out.println("Lv." + player.getLevel() + " 메소: " + player.getMeso()
                + "\nHP포션: " + player.getHpPotionCount() + "개"
                + " MP포션: " + player.getMpPotionCount() + "개");
    }

    public void printShop(PlayerDTO player) {
        System.out.println("=========== 상점 ==========");
        printStatus(player);
        System.out.println("1. HP 포션 구매/판매");
        System.out.println("2. MP 포션 구매/판매");
        System.out.println("0. 마을로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printBuyPotion(PlayerDTO player) {
        printStatus(player);
        System.out.println("== 구매 가격 ==");
        System.out.println("Lv.1~10 : 1개당 100메소\nLv.11~20 : 1개당 200메소" +
                "\nLv.21~30 : 1개당 400메소\nLv.31~ : 1개당 800메소");
        System.out.println("구매 개수를 입력하세요(구매 취소는 0 입력):");
    }

    public void printSellPotion(PlayerDTO player) {
        printStatus(player);
        System.out.println("== 판매 가격 ==");
        System.out.println("Lv.1~10 : 1개당 70메소\nLv.11~20 : 1개당 140메소" +
                "\nLv.21~30 : 1개당 280메소\nLv.31~ : 1개당 560메소");
        System.out.println("판매 개수를 입력하세요(구매 취소는 0 입력):");
    }
}
