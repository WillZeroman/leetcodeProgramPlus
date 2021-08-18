public class Fib {
    public int fib(int n) {
        if(n ==0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int first = 0;
        int second = 1;
        for(int i=2;i<=n;i++){
           int sum = first + second;
           first = second;
           second = sum%1000000007;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new Fib().fib(2));
        System.out.println(new Fib().fib(5));
        System.out.println(new Fib().fib(95));
    }
}
