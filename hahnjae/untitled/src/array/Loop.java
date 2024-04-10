package array;

public class Loop {

    public static void main(String[] args) {
        int thing1 = 2000;
        int thing2 = 1000;
        int thing3 = 3000;
        int thing4 = 3000;

        int sum = thing1 + thing2 + thing3 + thing4;

        for(int i = 0; i < 277; i++) {
            sum += thing1;
        }

        System.out.println("합계 = " + sum);
    }
}
