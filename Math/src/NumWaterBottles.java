public class NumWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        while (empty>=numExchange){
            empty -= numExchange;
            ans ++;
            empty ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumWaterBottles().numWaterBottles(15,4));
        System.out.println(new NumWaterBottles().numWaterBottles(15,8));
    }
}
