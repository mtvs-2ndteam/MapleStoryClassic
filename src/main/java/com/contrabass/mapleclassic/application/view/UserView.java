package com.contrabass.mapleclassic.application.view;

public class UserView {
    public void printUserInfo(String nickName, int level, String job) {
        System.out.println("★★★ " + nickName + " ★★★");
        System.out.println("LEVEL : " + level);
        System.out.println("직업 : " + job);
    }
}
