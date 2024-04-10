package array;

import java.util.Scanner;

public class Array2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] things = new int[277];
        things[0] = 2000;
        things[1] = 1000;
        things[2] = 3000;
        things[3] = 3000;

        int sum = 0;
        for(int i = 0; i < things.length; i++) {
            things[i] = scanner.nextInt();
            sum += things[i];
        }
        System.out.println("합계 = " + sum);
    }
}
