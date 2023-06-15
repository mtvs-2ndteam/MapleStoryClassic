package com.contrabass.mapleclassic;

import com.contrabass.mapleclassic.application.controller.GameController;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class Application {
    public static void main(String[] args) {
        CONTEXT.getBean("gameController", GameController.class).run();
    }
}