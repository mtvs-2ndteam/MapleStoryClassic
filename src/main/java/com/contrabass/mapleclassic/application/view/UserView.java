package com.contrabass.mapleclassic.application.view;

public class UserView {
    public void printUserInfo(String nickName, int level, String job) {
        System.out.println("★★★ " + nickName + " ★★★");
        System.out.println("LEVEL : " + level);
        System.out.println("직업 : " + job);
    }

    public void printSelectMyInfo() {
        System.out.println("\n내 정보 조회 중...\n");
        System.out.println("=========== 내 정보 ===========");
        System.out.println("1. 스텟 찍기");
        System.out.println("0. 로비로 가기");
    }
}
