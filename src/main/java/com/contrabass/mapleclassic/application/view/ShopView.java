package com.contrabass.mapleclassic.application.view;

public class ShopView {
    public void printShopMessage() {
        System.out.println("\n상점으로 이동...\n");
    }

    public void printHpPotionMessage() {
        System.out.println("\n=== HP 포션 === \n1. 구매하기\n2. 취소");
    }

    public void printMpPotionMessage() {
        System.out.println("\n=== MP 포션 === \n1. 구매하기\n2. 취소");
    }

    public void printSuccessMessage() {
        System.out.println("\n구매 성공!\n");
    }

    public void printFailMessage() {
        System.out.println("\n구매 실패...\n");
    }

    public void printShop() {
        System.out.println("=========== 상점 ==========");
        System.out.println("1. HP 포션 구매");
        System.out.println("2. MP 포션 구매");
        System.out.println("0. 마을로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }


    public void printBuyPotion(int meso, String mapName) {
        if (mapName.equals("헤네시스")) {
            System.out.println("구매 개수를 입력하세요(최대 구매 가능 개수: " + meso / 100 + "개 / 구매 취소는 0 입력):");
        }
        if (mapName.equals("커닝시티")) {
            System.out.println("구매 개수를 입력하세요(최대 구매 가능 개수: " + meso / 200 + "개 / 구매 취소는 0 입력):");
        }
        if (mapName.equals("페리온")) {
            System.out.println("구매 개수를 입력하세요(최대 구매 가능 개수: " + meso / 400 + "개 / 구매 취소는 0 입력):");
        }
        if (mapName.equals("엘리니아")) {
            System.out.println("구매 개수를 입력하세요(최대 구매 가능 개수: " + meso / 800 + "개 / 구매 취소는 0 입력):");
        }
    }
}
