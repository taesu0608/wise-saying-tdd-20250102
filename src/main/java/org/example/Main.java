package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //System.in --> 표준 입력

        System.out.println("Hello world!");

        Scanner scan = new Scanner("aaa\nbbb\n");

        String val1 = scan.nextLine();
        System.out.println(val1);
        
        String val2 = scan.nextLine();
        System.out.println(val2);

        String val3 = scan.nextLine();
        System.out.println(val3);
        //테스트봇 만들기

        TestApp app = new TestApp();
        app.run();
    }
}