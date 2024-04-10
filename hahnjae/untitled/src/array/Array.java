package array;

public class Array {

    public static void main(String[] args) {
        int[] things = new int[277];
        things[0] = 2000;
        things[1] = 1000;
        things[2] = 3000;
        things[3] = 3000;

        int sum = things[0] + things[1] + things[2] + things[3];

        System.out.println("합계 = " + sum);
    }
}
