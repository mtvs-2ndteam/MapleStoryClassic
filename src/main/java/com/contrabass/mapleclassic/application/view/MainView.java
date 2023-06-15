package com.contrabass.mapleclassic.application.view;

public class MainView {
    public void printStartView() {
        System.out.println("로딩 중...");
        System.out.println("로그인이 필요합니다.");
    }

    public void printLoginIdView() {
        System.out.println("아이디를 입력하세요.");
    }

    public void printLoginPwView() {
        System.out.println("비밀번호를 입력하세요.");
    }

    public void printLoginView() {
        System.out.println("=====Maple World=====");
        System.out.println("메인으로 이동 중...\n. . .");
    }

    public void printMainPage(String nickName, int level, String job) {
        System.out.println("==========메인 화면==========");
        System.out.println(nickName + " 님의 정보");
        System.out.println("닉네임 : " + nickName);
        System.out.println("LEVEL : " + level);
        System.out.println("직업 : " + job);
    }


}
