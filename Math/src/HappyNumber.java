import java.util.HashSet;

public class HappyNumber {



    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int prev = n;
        while (prev != 1) {
            int sqr = sum(prev);
            if (set.contains(sqr)) {
                return false;
            }
            set.add(sqr);
            prev = sqr;
        }
        return prev == 1;
    }

    private int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            int sqr = num * num;
            sum += sqr;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
        System.out.println(new HappyNumber().isHappy(5));
    }
}
