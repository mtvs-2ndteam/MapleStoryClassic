package com.contrabass.mapleclassic.application.service;

import com.contrabass.mapleclassic.application.controller.SaunaController;
import com.contrabass.mapleclassic.domain.entity.PlayerDTO;
import com.contrabass.mapleclassic.domain.service.GameDomainService;
import org.springframework.stereotype.Service;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

@Service
public class SaunaService {
    SaunaController saunaController = CONTEXT.getBean("saunaController", SaunaController.class);
    GameDomainService gameDomainService = CONTEXT.getBean("gameDomainService", GameDomainService.class);

    // 현재 유저의 메소가 충분한지 판단
    public void connectPremiumSauna(PlayerDTO player) {
        if (player.getLevel() > 0 && player.getLevel() < 11) {
            saunaController.usePremiumSauna(
                    gameDomainService.judgeMeso(player.getMeso(), 1000), player);
        }
        if (player.getLevel() > 10 && player.getLevel() < 21) {
            saunaController.usePremiumSauna(
                    gameDomainService.judgeMeso(player.getMeso(), 2000), player);
        }
        if (player.getLevel() > 20 && player.getLevel() < 31) {
            saunaController.usePremiumSauna(
                    gameDomainService.judgeMeso(player.getMeso(), 4000), player);
        }
        if (player.getLevel() > 30) {
            saunaController.usePremiumSauna(
                    gameDomainService.judgeMeso(player.getMeso(), 8000), player);
        }
    }

    public void connectNormalSauna(PlayerDTO player) {
        if (player.getLevel() > 0 && player.getLevel() < 11) {
            saunaController.useNormalSauna(
                    gameDomainService.judgeMeso(player.getMeso(), 500), player);
        }
        if (player.getLevel() > 10 && player.getLevel() < 21) {
            saunaController.useNormalSauna(
                    gameDomainService.judgeMeso(player.getMeso(), 1000), player);
        }
        if (player.getLevel() > 20 && player.getLevel() < 31) {
            saunaController.useNormalSauna(
                    gameDomainService.judgeMeso(player.getMeso(), 2000), player);
        }
        if (player.getLevel() > 30) {
            saunaController.useNormalSauna(
                    gameDomainService.judgeMeso(player.getMeso(), 4000), player);
        }
    }

    // 사우나 종류에 따른 회복
    public void goSauna(int time, PlayerDTO player, String type) {
        int standard = 0;

        // 프리미엄 사우나
        if (player.getLevel() > 0 && player.getLevel() < 11 && type.equals("프리미엄")) {
            standard = 1000;
        }
        if (player.getLevel() > 10 && player.getLevel() < 21 && type.equals("프리미엄")) {
            standard = 2000;
        }
        if (player.getLevel() > 20 && player.getLevel() < 31 && type.equals("프리미엄")) {
            standard = 4000;
        }
        if (player.getLevel() > 30 && type.equals("프리미엄")) {
            standard = 8000;
        }

        // 일반 사우나
        if (player.getLevel() > 0 && player.getLevel() < 11 && type.equals("일반")) {
            standard = 500;
        }
        if (player.getLevel() > 10 && player.getLevel() < 21 && type.equals("일반")) {
            standard = 1000;
        }
        if (player.getLevel() > 20 && player.getLevel() < 31 && type.equals("일반")) {
            standard = 2000;
        }
        if (player.getLevel() > 30 && type.equals("일반")) {
            standard = 4000;
        }
        gameDomainService.recover(time, player, standard);
    }
}
