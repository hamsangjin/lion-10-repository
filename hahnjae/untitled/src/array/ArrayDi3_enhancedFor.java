package array;

import java.util.Scanner;

public class ArrayDi3_enhancedFor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] things = {1, 2, 3, 277};


        for(int i = 0; i < things.length; i++) {
            int thing = things[i];
            System.out.println(thing);
        }

        for(int thing : things) {
            System.out.println(thing);
        }
    }
}
