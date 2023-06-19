package com.contrabass.mapleclassic;

import com.contrabass.mapleclassic.application.view.MainView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.contrabass.mapleclassic");

        context.getBean("mainView",
                MainView.class).lobbyView();
    }
}
