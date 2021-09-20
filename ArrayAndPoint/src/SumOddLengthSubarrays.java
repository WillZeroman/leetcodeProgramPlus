public class SumOddLengthSubarrays {
    /**
     * O(n^3)
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for (int i = 1; i <= arr.length; i+=2) {
            for (int j = 0; j < arr.length; j++) {
                if(j+i-1<arr.length){
                    int len = 0;
                    while (len <i){
                        ans +=arr[j+len];
                        len ++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * O(n^2) O(n)
     * 前缀和
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays_best(int[] arr) {
        int[] prefixSum = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i+1] = prefixSum[i]+arr[i];
        }
        int ans = 0;
        for (int left = 0; left < arr.length; left++) {
            for (int len = 1; len <= arr.length; len+=2) {
                if(left + len-1<arr.length){
                    ans += prefixSum[left+len] - prefixSum[left];
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(new SumOddLengthSubarrays().sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        System.out.println(new SumOddLengthSubarrays().sumOddLengthSubarrays_best(new int[]{1,4,2,5,3}));
        System.out.println(new SumOddLengthSubarrays().sumOddLengthSubarrays_best(new int[]{1,2}));
        System.out.println(new SumOddLengthSubarrays().sumOddLengthSubarrays(new int[]{1,2}));
        System.out.println(new SumOddLengthSubarrays().sumOddLengthSubarrays(new int[]{10,11,12}));
    }
}
