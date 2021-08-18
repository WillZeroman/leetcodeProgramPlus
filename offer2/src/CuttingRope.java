public class CuttingRope {

    // 贪心
    public int cuttingRope(int n) {
        if(n == 2 ){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        if(n == 4){
            return 4;
        }
        long sum = 1;
        while (n>4){
            sum *=3;
            sum %= 1000000007;
            n -=3;
        }
        return (int)(sum * n % 1000000007);
    }

    // 动态规划

    public static void main(String[] args) {
        System.out.println(new CuttingRope().cuttingRope(120));
        System.out.println(new CuttingRope().cuttingRope(127));
    }
}
