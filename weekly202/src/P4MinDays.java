import java.util.HashMap;
import java.util.Map;

public class P4MinDays {

    private int[] array;
    private int count;

    public int minDays(int n) {
//        if (array == null) {
//            array = new int[n + 1];
//        }
//        int value = array[n];
//        if (value != 0) {
//            return value;
//        }
        if (n == 1) {
            return 1;
        }
        if (n == 2 || n == 3) {
            return 2;
        }
        int firstMinDays = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            firstMinDays = minDays(n / 3);
            //array[n] = firstMinDays + 1;
            return firstMinDays + 1;
        } else {
            int secondMinDays = Integer.MAX_VALUE;
            if (n % 2 == 0) {
                secondMinDays = minDays(n / 2);
            }
            int thirdMinDays = minDays(n - 1);
            int min = Math.min(secondMinDays, thirdMinDays);
            return min + 1;
        }
        //array[n] = min + 1;
        //System.out.println(count++ + " " + n);

//        return array[n];
    }

    public static void main(String[] args) {
//        System.out.println(new P4MinDays().minDays(10));
//        System.out.println(new P4MinDays().minDays(6));
//        System.out.println(new P4MinDays().minDays(1));
        System.out.println(new P4MinDays().minDays(84806671));
    }
}
