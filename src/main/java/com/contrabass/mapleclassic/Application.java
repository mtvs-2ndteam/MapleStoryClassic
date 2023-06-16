package com.contrabass.mapleclassic;

import com.contrabass.mapleclassic.application.controller.GameController;
import com.contrabass.mapleclassic.domain.entity.UserDTO;
import com.contrabass.mapleclassic.domain.service.UserDomainService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.contrabass.mapleclassic.Constant.CONTEXT;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.contrabass.mapleclassic");

        UserDomainService bookService = context.getBean("bookServiceField",  UserDomainService.class);
        bookService.InsertUserId(3,"aa","aa","aa");
        bookService.DeleteUserId(2);
        bookService.UpdateUserId(1,"ab","aa","aa");

        bookService.validateUserId("hi");

    }
}
