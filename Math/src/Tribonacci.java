public class Tribonacci {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n ==1||n==2){
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }
    public int tribonacci_dp(int n){
        if(n==0){
            return 0;
        }
        if(n ==1||n==2){
            return 1;
        }
        int[] arr = new int[]{0,1,1};
        for (int i = 3; i <= n; i++) {
            int sum = arr[0] + arr[1]+arr[2];
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = sum;
        }
        return arr[2];
    }

    public static void main(String[] args) {
        System.out.println(new Tribonacci().tribonacci_dp(4));
        System.out.println(new Tribonacci().tribonacci(4));
        System.out.println(new Tribonacci().tribonacci_dp(25));
        System.out.println(new Tribonacci().tribonacci(25));
    }
}
