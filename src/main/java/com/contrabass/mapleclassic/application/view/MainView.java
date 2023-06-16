package com.contrabass.mapleclassic.application.view;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class MainView {
    UserView userView = CONTEXT.getBean("userView", UserView.class);

    public void printStartView() {
        System.out.println("로딩 중...\n. . .\n");
        System.out.println("로그인이 필요합니다.");
    }

    public void printLoginIdView() {
        System.out.println("아이디를 입력하세요.");
    }

    public void printLoginPwView() {
        System.out.println("비밀번호를 입력하세요.");
    }

    public void printSuccessLoginView() {
        System.out.println("로그인 성공!\n");
        System.out.println("===============Maple World===============");
        System.out.println("\n로비로 이동 중...\n. . .\n");
        System.out.println("========== 로비 입장 ==========");
    }

    public void printLobby() {
        System.out.println("========== 로비 ==========");
        System.out.println("1. 내 정보");
        System.out.println("2. 마을 이동");
        System.out.println("0. 게임 종료");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printMapMovement() {
        System.out.println("===== 이동할 마을을 선택하세요 =====");
        System.out.println("1. 헤네시스 (레벨 1~10 입장 가능)");
        System.out.println("2. 커닝시티 (레벨 11~20 입장 가능)");
        System.out.println("3. 페리온 (레벨 21~30 입장 가능)");
        System.out.println("4. 엘리니아 (레벨 31~ 입장 가능)");
        System.out.println("0. 로비로 가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printBackMessage() {
        System.out.println("\n뒤로 갑니다...\n");
    }

    public void printLobbyMessage() {
        System.out.println("\n로비로 갑니다...\n");
    }

    public void printErrorMessage() {
        System.out.println("\n잘못 입력하셨습니다. 다시 입력해 주세요.\n");
    }

    public void printEndMessage() {
        System.out.println("\n프로그램 종료...\n");
    }


}
