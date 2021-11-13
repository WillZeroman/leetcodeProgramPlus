public class MinSteps {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int ans = 0;
        int num = n;
        while (num != 1) {
            int prime = maxPrime(num);
            if (prime != 1) {
                int count = num / prime;
                ans += count;
                num = prime;
            } else {
                break;
            }
        }
        ans += num;
        return ans;
    }

    private int maxPrime(int num) {
        int cursor = num / 2;
        for (int i = cursor; i > 1; i--) {
            if (num % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new MinSteps().minSteps(9));
    }
}
