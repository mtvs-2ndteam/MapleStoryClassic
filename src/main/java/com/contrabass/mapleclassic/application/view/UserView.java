package com.contrabass.mapleclassic.application.view;

import com.contrabass.mapleclassic.domain.entity.PlayerDTO;

public class UserView {

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
}
