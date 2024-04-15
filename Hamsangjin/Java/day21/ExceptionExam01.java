package com.example.day21;

public class ExceptionExam01 {
    public static void main(String[] args) {
        int[] iarr = {1, 2, 3};

        try {
            int result = 10 / 0;
            System.out.println(iarr[3]);
        // 이렇게 하면 모든 예외처리가 가능함
        // } catch (Exception e){
        //     e.printStackTrace();
        // }

        // 각각 catch 안의 오류에 알맞은 예외만 처리를 해준다.
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

        System.out.println("다음 문장 1");
        System.out.println("다음 문장 2");
        System.out.println("다음 문장 3");
        System.out.println("end !!");
    }
}
