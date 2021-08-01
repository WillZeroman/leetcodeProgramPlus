public class HammingDistance {


    public int hammingDistance(int x, int y) {
        int sum = x ^ y;
        int ans = 0;
        while (sum != 0) {
            if (sum % 2 == 1) {
                ans++;
            }
            sum >>= 1;
        }

        // Integer.bitCount(x ^ y);
        return ans;
    }

    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1, 4));
    }
}
