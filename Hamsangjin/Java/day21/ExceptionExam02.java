package com.example.day21;

public class ExceptionExam02 {
    public static void main(String[] args) {
        System.out.println("프로그램 시작");

        try {
            int i = Integer.parseInt(args[0]);
            System.out.println(10/i);
        } catch (ArithmeticException e){
            e.printStackTrace();
        }
        System.out.println("프로그램 종료");
    }
}
