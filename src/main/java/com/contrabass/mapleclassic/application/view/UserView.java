package com.contrabass.mapleclassic.application.view;

public class UserView {
    int userLevel = 11; // 유저 정보 불러오는 메소드 써야함

    public void printMyInfoMessage() {
        System.out.println("\n내 정보 조회 중...\n");
    }

    public void printUserInfo(String nickName, int level, String job) {
        System.out.println(nickName + "  Lv." + level + "  " + job + "\nHP: 1000" + "\nMP: 1000");
    }

    public void printUserDetailInfo(String nickName, int level, String job) {
        System.out.println(nickName + "  Lv." + level + "  " + job
                + "\nHP: 1000" + "\nMP: 1000"
                + "\n공격력: 1000" + " 크리티컬 확률: 90% " + " 크리티컬 데미지: 20%");
    }

    public void printSelectMyInfo() {
        printUserDetailInfo("뭐함", userLevel, "마법사");
        System.out.println("=========== 내 정보 ===========");
        System.out.println("1. 스텟 찍기");
        System.out.println("0. 로비로 가기");
    }
}
