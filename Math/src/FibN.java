public class FibN {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new FibN().fib(10));
        System.out.println(new FibN().fib(30));
        System.out.println(new FibN().fib(5));
    }
}
