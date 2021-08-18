public class NumWays {
    public int numWays(int n) {
        if(n ==0||n == 1){
            return 1;
        }
        int first = 1;
        int second = 1;
        for(int i=2;i<=n;i++){
            int sum = (first+second)%1000000007;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new NumWays().numWays(7));
        System.out.println(new NumWays().numWays(2));
    }
}
