package array;

import java.util.Scanner;

public class ArrayDi2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] things = new int[3][277];

        int sum = 0;
        for(int row = 0; row < things.length; row++) {
            for(int column = 0; column < things[row].length; column++) {
                sum += things[row][column];
            }
        }
        System.out.println("합계 = " + sum);
    }
}
