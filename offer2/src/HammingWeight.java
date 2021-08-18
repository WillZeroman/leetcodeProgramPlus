public class HammingWeight {
    public int hammingWeight(int n) {
        int ans = 0;

        for(int i=0;i<32;i++){
            if((n & (1<<i)) !=0){
                ans ++;
            }
        }
        return ans;

        //return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(11));
    }
}
