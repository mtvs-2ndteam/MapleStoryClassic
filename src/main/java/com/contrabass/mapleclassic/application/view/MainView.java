package com.contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.application.controller.GameController;
import com.contrabass.mapleclassic.application.dto.PlayerDTO;
import com.contrabass.mapleclassic.application.dto.SaunaDTO;
import com.contrabass.mapleclassic.application.dto.ShopDTO;
import com.contrabass.mapleclassic.utils.MainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainView {
    private final GameController gameController; // 회원가입 및 로그인 때문에 남겨둠
    private final MainException mainException;
    private final PlayerDTO playerDTO;
    private final ShopDTO shopDTO;
    private final SaunaDTO saunaDTO;

    @Autowired
    public MainView(GameController gameController, MainException mainException
            , PlayerDTO playerDTO, ShopDTO shopDTO, SaunaDTO saunaDTO) {
        this.gameController = gameController;
        this.mainException = mainException;
        this.playerDTO = playerDTO;
        this.shopDTO = shopDTO;
        this.saunaDTO = saunaDTO;
    }


    ///// 로비 /////
    public void lobbyView() {
        printStartView();
        printLoginIdView();
        printLoginPwView();
        printSuccessLoginView();
        while (true) {
            printUserInfo(playerDTO);
            printLobby();
            int selectNum = input();

            // 1. 내 정보
            if (selectNum == 1) {
                myInfoView();
                continue;
            }
            // 2. 마을 이동
            if (selectNum == 2) {
                selectMapView();
                continue;
            }
            // 0. 게임 종료
            if (selectNum == 0) {
                break;
            }
            // 에러
            printErrorMessage();
        }
    }

    ///// 내 정보 /////
    public void myInfoView() {
        printMyInfoMessage();
        while (true) {
            printSelectMyInfo(playerDTO);
            int selectNum = input();

            // 1. 스텟 찍기
            if (selectNum == 1) {
//                playerDAO.checkStat();
                printStatusMessage();
                continue;
            }

            // 0. 로비
            if (selectNum == 0) {
                printLobbyMessage();
                return;
            }

            // 에러
            printErrorMessage();
        }
    }

    ///// 마을 이동 /////
    public void selectMapView() {

        printSelectMapsMessage();
        while (true) {
            printMapMovement();
            int selectNum = input();

            // 1. 헤네시스(레벨 1 이상 입장 가능)
            // 2. 커닝시티(레벨 11 이상 입장 가능)
            // 3. 페리온(레벨 21 이상 입장 가능)
            // 4. 엘리니아(레벨 31 이상 입장 가능)
            if (selectNum == 1
                    || selectNum == 2
                    || selectNum == 3
                    || selectNum == 4) {
                selectMaps(selectNum, playerDTO);
                continue;
            }
            // 0. 로비
            if (selectNum == 0) {
                printLobbyMessage();
                return;
            }
            // 에러
            printErrorMessage();
        }
    }

    // 선택 번호와 레벨에 따른 마을 이동 판단
    public void selectMaps(int selectNum, PlayerDTO player) {
        String judgeLevel = gameController.judgeLevelController(player.getLevel());
        String map = "";

        // 정상 입장
        if ((judgeLevel.equals("헤네시스")
                || judgeLevel.equals("커닝시티")
                || judgeLevel.equals("페리온")
                || judgeLevel.equals("엘리니아")) && selectNum == 1) {
            mapView("헤네시스", player);
        }
        if ((judgeLevel.equals("커닝시티")
                || judgeLevel.equals("페리온")
                || judgeLevel.equals("엘리니아")) && selectNum == 2) {
            System.out.println("커닝시티 공사 중...");
//            mapView("커닝시티", player);
        }
        if ((judgeLevel.equals("페리온")
                || judgeLevel.equals("엘리니아")) && selectNum == 3) {
            System.out.println("페리온 공사 중...");
//            mapView("페리온", player);
        }
        if (judgeLevel.equals("엘리니아") && selectNum == 4) {
            System.out.println("엘리니아 공사 중...");
//            mapView("엘리니아", player);
        }

        // 잘못된 입장
        if (judgeLevel.equals("헤네시스") && selectNum == 2) {
            printEnterError("커닝시티");
        }
        if ((judgeLevel.equals("헤네시스")
                || judgeLevel.equals("커닝시티")) && selectNum == 3) {
            printEnterError("페리온");
        }
        if ((judgeLevel.equals("헤네시스")
                || judgeLevel.equals("커닝시티")
                || judgeLevel.equals("페리온")) && selectNum == 4) {
            printEnterError("엘리니아");
        }
    }

    ///// 헤네시스 (레벨 1 이상 입장 가능) /////
    ///// 커닝시티 (레벨 11 이상 입장 가능) /////
    ///// 페리온 (레벨 21 이상 입장 가능) /////
    ///// 엘리니아 (레벨 31 이상 입장 가능) /////
    public void mapView(String map, PlayerDTO player) {
        printEnterMapMessage(map);
        while (true) {
            printMenu(map);
            int selectNum = input();

            // 1. 상점
            if (selectNum == 1) {
                shopView(player);
                continue;
            }
            // 2. 사우나
            if (selectNum == 2) {
                selectSauna(player);
                continue;
            }
            // 3. 사냥터
            if (selectNum == 3) {
//                selectFightMap(map);
                continue;
            }
            // 4. 보스
            if (selectNum == 4) {
                continue;
            }
            // 5. 전직
            if (selectNum == 5) {
//                selectJob();
                continue;
            }
            // 0. 마을 선택으로 돌아가기
            if (selectNum == 0) {
                printSelectTownMessage();
                return;
            }
            // 에러
            printErrorMessage();
        }
    }

    ///// 상점 /////
    public void shopView(PlayerDTO player) {
        printShopMessage();
        while (true) {
            printShop(player);
            int selectNum = input();

            // 1. HP 물약
            if (selectNum == 1) {
                selectHpShop(player);
                continue;
            }
            // 2. MP 물약
            if (selectNum == 2) {
                selectMpShop(player);
                continue;
            }
            // 0. 마을로 돌아가기
            if (selectNum == 0) {
                printBackTownMessage();
                return;
            }
            // 에러
            printErrorMessage();
        }
    }

    ///// HP 포션 /////
    public void selectHpShop(PlayerDTO player) {
        while (true) {
            printHpPotionMessage();
            int selectNum = input();

            // 1. 구매하기
            if (selectNum == 1) {
                buyPotion(player, "HP");
                return;
            }
            // 2. 판매하기
            if (selectNum == 2) {
                sellPotion(player, "HP");
                return;
            }
            // 0. 취소
            if (selectNum == 0) {
                printCancelMessage();
                return;
            }
            // 에러
            printErrorMessage();
        }
    }

    ///// MP 포션 /////
    public void selectMpShop(PlayerDTO player) {
        while (true) {
            printMpPotionMessage();
            int selectNum = input();

            // 1. 구매하기
            if (selectNum == 1) {
                buyPotion(player, "MP");
                return;
            }
            // 2. 판매하기
            if (selectNum == 2) {
                sellPotion(player, "MP");
                return;
            }
            // 0. 취소
            if (selectNum == 0) {
                printCancelMessage();
                return;
            }
            // 에러
            printErrorMessage();
        }
    }

    // 포션 구매
    public void buyPotion(PlayerDTO player, String type) {
        String result = "";

        while (true) {
            printBuyPotion(player);
            shopDTO.setPlayer(player);
            shopDTO.setWantCount(input());

            // 포션 종류별 계산
            if (type.equals("HP")) {
                shopDTO.setType(type);
                result = gameController.buyPotionCountController(shopDTO);
            }
            if (type.equals("MP")) {
                shopDTO.setType(type);
                result = gameController.buyPotionCountController(shopDTO);
            }

            // 구매 성공
            if (result.equals("성공")) {
                printBuySuccessMessage();
                return;
            }
            // 실패
            if (result.equals("실패")) {
                printBuyFailMessage();
                continue;
            }
            // 취소
            if (result.equals("취소")) {
                printCancelMessage();
                return;
            }
            // 에러
            printErrorMessage();
        }
    }

    // 포션 판매
    public void sellPotion(PlayerDTO player, String type) {
        String result = "";

        while (true) {
            printSellPotion(player);
            shopDTO.setPlayer(player);
            shopDTO.setWantCount(input());

            // 포션 종류별 계산
            if (type.equals("HP")) {
                shopDTO.setType(type);
                result = gameController.sellPotionCountController(shopDTO);
            }
            if (type.equals("MP")) {
                shopDTO.setType(type);
                result = gameController.sellPotionCountController(shopDTO);
            }

            // 판매 성공
            if (result.equals("성공")) {
                printSellSuccessMessage();
                return;
            }
            // 실패
            if (result.equals("실패")) {
                printSellFailMessage();
                continue;
            }
            // 취소
            if (result.equals("취소")) {
                printCancelMessage();
                return;
            }
            // 에러
            printErrorMessage();
        }
    }


    ///// 사우나 선택 /////
    public void selectSauna(PlayerDTO player) {
        printSaunaMessage();
        while (true) {
            printSauna(player);
            int selectNum = input();
            saunaDTO.setPlayer(player);

            // 1. 5초 이용
            if (selectNum == 1) {
                saunaDTO.setType("프리미엄");
                useSauna(saunaDTO, gameController.connectSaunaController(saunaDTO));
                continue;
            }
            // 2. 10초 이용
            if (selectNum == 2) {
                saunaDTO.setType("일반");
                useSauna(saunaDTO, gameController.connectSaunaController(saunaDTO));
                continue;
            }
            // 0. 마을로 돌아가기
            if (selectNum == 0) {
                printBackTownMessage();
                return;
            }
            // 에러
            printErrorMessage();
        }
    }

    ///// 사우나 이용 /////
    public void useSauna(SaunaDTO saunaDTO, String result) {
        // 성공
        if (result.equals("성공") && saunaDTO.getType().equals("프리미엄")) {
            printPremiumSaunaMessage();
            gameController.goSaunaController(saunaDTO, 5);
            printSuccessMessage();
            return;
        }
        if (result.equals("성공") && saunaDTO.getType().equals("일반")) {
            printNormalSaunaMessage();
            gameController.goSaunaController(saunaDTO, 10);
            printSuccessMessage();
            return;
        }
        // 실패
        printFailMessage();
    }


//    public void selectJob() {
//
//        PlayerDTO player = new PlayerDTO();
//        npcView.npcSelectView();
//
//        while (true) {
//
//            int selectNum = mainView.input();
//
//            // 1. 전사 선택
//            if (selectNum == 1) {
//                npcView.JobSelect(player, 1);
//                continue;
//            }
//            // 2. 마법사 선택
//            if (selectNum == 2) {
//                npcView.JobSelect(player, 2);
//                continue;
//            }
//            // 3. 도적 선택
//            if (selectNum == 3) {
//                npcView.JobSelect(player, 3);
//                continue;
//            }
//            // 4. 궁수 선택
//            if (selectNum == 4) {
//                npcView.JobSelect(player, 4);
//                continue;
//            }
//            // 0. 마을로 돌아가기
//            if (selectNum == 0) {
//                printBackTownMessage();
//                return;
//            }
//            // 에러
//            printErrorMessage();
//        }
//    }


    //////////////////////////////////////// 메인 출력 ////////////////////////////////////////
    public int input() {
        return mainException.solveInputValueException(new Scanner(System.in).nextLine());
    }

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
        System.out.println("========== 로비 입장 ==========\n");
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
        System.out.println("1. 헤네시스 (레벨 1 이상 입장 가능)");
        System.out.println("2. 커닝시티 (레벨 11 이상 입장 가능)");
        System.out.println("3. 페리온 (레벨 21 이상 입장 가능)");
        System.out.println("4. 엘리니아 (레벨 31 이상 입장 가능)");
        System.out.println("0. 로비로 가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printSelectTownMessage() {
        System.out.println("\n마을 선택으로 돌아갑니다...\n");
    }

    public void printBackTownMessage() {
        System.out.println("\n마을로 돌아갑니다...\n");
    }

    public void printLobbyMessage() {
        System.out.println("\n로비로 돌아갑니다...\n");
    }

    public void printStatusMessage() {
        System.out.println("1. 공격력");
        System.out.println("2. 마력");
        System.out.println("3. 방어력");
        System.out.println("4. 크리티컬확률");
        System.out.println("5. 크리티컬데미지");
        System.out.println("0. 돌아가기");
    }

    public void printErrorMessage() {
        System.out.println("\n잘못 입력하셨습니다. 다시 입력해 주세요.\n");
    }

    public void printEndMessage() {
        System.out.println("\n게임을 종료합니다...\n");
    }


    public void printCancelMessage() {
        System.out.println("\n취소했습니다.\n");
    }


    //////////////////////////////////////// 내 정보 출력 ////////////////////////////////////////
    public void printMyInfoMessage() {
        System.out.println("\n내 정보 조회 중...\n");
    }

    public void printUserInfo(PlayerDTO player) {
        System.out.println(player.getNickName() + "  Lv." + player.getLevel() + "  " + player.getJob()
                + "\nHP: " + player.getBaseHp() + "/" + player.getMaxHp()
                + "  MP: " + player.getBaseMp() + "/" + player.getMaxMp()
                + "\n메소: " + player.getMeso()
                + "  HP포션: " + player.getHpPotionCount()
                + "개  MP포션: " + player.getMpPotionCount() + "개");
    }

    public void printUserDetailInfo(PlayerDTO player) {
        System.out.println(player.getNickName() + "  Lv." + player.getLevel() + "  " + player.getJob()
                + "\nHP: " + player.getBaseHp() + "/" + player.getMaxHp()
                + "  MP: " + player.getBaseMp() + "/" + player.getMaxMp()
                + "\n공격력: " + player.getAtk() + "  방어력: " + player.getArmor()
                + "\n크리티컬 확률: " + player.getCriPercent() + "%  크리티컬 데미지: " + player.getCriPercent() + "%");
    }

    public void printSelectMyInfo(PlayerDTO player) {
        printUserDetailInfo(player);
        System.out.println("=========== 내 정보 ===========");
        System.out.println("1. 스텟 찍기");
        System.out.println("0. 로비로 가기");
    }


    //////////////////////////////////////// 맵 출력 ////////////////////////////////////////
    public void printSelectMapsMessage() {
        System.out.println("\n마을 선택으로 이동...\n");
    }

    public void printEnterMapMessage(String map) {
        if (map.equals("헤네시스")) {
            System.out.println("\n헤네시스로 이동...\n");
        }
        if (map.equals("커닝시티")) {
            System.out.println("\n커닝시티로 이동...\n");
        }
        if (map.equals("페리온")) {
            System.out.println("\n페리온으로 이동...\n");
        }
        if (map.equals("엘리니아")) {
            System.out.println("\n엘리니아로 이동...\n");
        }
    }

    public void printMenu(String map) {
        if (map.equals("헤네시스")) {
            printUserInfo(playerDTO);
            System.out.println("=========== 헤네시스 ==========");
            printSelectMenu();
            System.out.println("4. 자쿰(보스) 이동");
            printSelectNpcMenu();
            System.out.println("0. 마을 선택으로 돌아가기");
            System.out.println("메뉴 번호 입력: ");
        }
        if (map.equals("커닝시티")) {
            printUserInfo(playerDTO);
            System.out.println("=========== 커닝시티 ==========");
            printSelectMenu();
            System.out.println("4. 핑크빈(보스) 이동");
            printSelectNpcMenu();
            System.out.println("0. 마을 선택으로 돌아가기");
            System.out.println("메뉴 번호 입력: ");
        }
        if (map.equals("페리온")) {
            printUserInfo(playerDTO);
            System.out.println("=========== 페리온 ==========");
            printSelectMenu();
            System.out.println("4. 루시드(보스) 이동");
            printSelectNpcMenu();
            System.out.println("0. 마을 선택으로 돌아가기");
            System.out.println("메뉴 번호 입력: ");
        }
        if (map.equals("엘리니아")) {
            printUserInfo(playerDTO);
            System.out.println("=========== 엘리니아 ==========");
            printSelectMenu();
            System.out.println("4. 검은마법사(보스) 이동");
            printSelectNpcMenu();
            System.out.println("0. 마을 선택으로 돌아가기");
            System.out.println("메뉴 번호 입력: ");
        }
    }

    public void printSelectMenu() {
        System.out.println("1. 상점");
        System.out.println("2. 사우나");
        System.out.println("3. 사냥터 이동");
    }

    public void printEnterError(String map) {
        if (map.equals("커닝시티")) {
            System.out.println("\n커닝시티는 레벨 11 이상부터 입장 가능합니다.\n");
        }
        if (map.equals("페리온")) {
            System.out.println("\n페리온은 레벨 21 이상부터 입장 가능합니다.\n");
        }
        if (map.equals("엘리니아")) {
            System.out.println("\n엘리니아는 레벨 31 이상부터 입장 가능합니다.\n");
        }
    }

    public void printSelectNpcMenu() {
        System.out.println("5. 전직하러 가기");
    }


    //////////////////////////////////////// 상점 출력 ////////////////////////////////////////
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
        System.out.println("\n메소가 부족합니다...\n");
    }

    public void printSellFailMessage() {
        System.out.println("\n판매 실패...\n");
    }

    public void printStatus(PlayerDTO player) {
        System.out.println(player.getNickName() + "  Lv." + player.getLevel() + "  메소: " + player.getMeso()
                + "\nHP포션: " + player.getHpPotionCount() + "개"
                + " MP포션: " + player.getMpPotionCount() + "개");
    }

    public void printShop(PlayerDTO player) {
        System.out.println("=========== 상점 ==========");
        printStatus(player);
        System.out.println("\n1. HP 포션 구매/판매");
        System.out.println("2. MP 포션 구매/판매");
        System.out.println("0. 마을로 돌아가기");
        System.out.println("메뉴 번호 입력: ");
    }

    public void printBuyPotion(PlayerDTO player) {
        System.out.println();
        printStatus(player);
        System.out.println("\n== 구매 가격 ==");
        System.out.println("Lv.1~10 : 1개당 100메소\nLv.11~20 : 1개당 200메소" +
                "\nLv.21~30 : 1개당 400메소\nLv.31~ : 1개당 800메소");
        System.out.println("구매 개수를 입력하세요(구매 취소는 0 입력):");
    }

    public void printSellPotion(PlayerDTO player) {
        System.out.println();
        printStatus(player);
        System.out.println("\n== 판매 가격 ==");
        System.out.println("Lv.1~10 : 1개당 70메소\nLv.11~20 : 1개당 140메소" +
                "\nLv.21~30 : 1개당 280메소\nLv.31~ : 1개당 560메소");
        System.out.println("판매 개수를 입력하세요(구매 취소는 0 입력):");
    }


    //////////////////////////////////////// 사우나 출력 ////////////////////////////////////////
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
