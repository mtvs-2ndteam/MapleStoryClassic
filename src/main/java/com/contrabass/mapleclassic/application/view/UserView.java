package com.contrabass.mapleclassic.application.view;

public class UserView {
    int userLevel = 11; // 유저 정보 불러오는 메소드 써야함

    public void printMyInfoMessage() {
        System.out.println("\n내 정보 조회 중...\n");
    }

    public void printUserInfo(String nickName, int level, String job) {
        System.out.println("닉네임 : " + nickName);
        System.out.println("LEVEL : " + level);
        System.out.println("직업 : " + job);
    }

    public void printSelectMyInfo() {
        printUserInfo("뭐함", userLevel, "마법사");
        System.out.println("=========== 내 정보 ===========");
        System.out.println("1. 스텟 찍기");
        System.out.println("0. 로비로 가기");
    }
}
