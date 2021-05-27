public class IsUgly {
    public boolean isUgly(int n) {

        while (n > 1) {
            boolean div = false;
            if (n % 2 == 0) {
                n /= 2;
                div = true;
            }
            if (n % 3 == 0) {
                n /= 3;
                div = true;
            }
            if (n % 5 == 0) {
                n /= 5;
                div = true;
            }
            if (!div && n > 1) {
                return false;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new IsUgly().isUgly(6));
        System.out.println(new IsUgly().isUgly(8));
        System.out.println(new IsUgly().isUgly(1));
        System.out.println(new IsUgly().isUgly(14));
    }
}
