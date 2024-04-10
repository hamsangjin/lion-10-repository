package array;

import java.util.Scanner;

public class Array3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] things = new int[277];

        int sum = 0;
        for(int i = 0; i < things.length; i++) {
            things[i] = scanner.nextInt();
            sum += things[i];
        }
        System.out.println("합계 = " + sum);
    }
}
