package com.contrabass.mapleclassic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Constant {
    public final static Scanner SCANNER = new Scanner(System.in);
    public final static ApplicationContext CONTEXT = new AnnotationConfigApplicationContext(ContextConfiguration.class);
}