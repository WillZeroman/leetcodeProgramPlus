package prefix;

import java.util.HashMap;

public class CheckSubarraySum {
    /**
     * 前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            sum %=k;
            if(sum == 0 && i>=2){
                return true;
            }
            int remain = k - sum;
            if(prefixSumMap.containsKey(remain)){
                return true;
            }
            prefixSumMap.put(sum,i);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CheckSubarraySum().checkSubarraySum(new int[]{23,2,6,4,7},4));
        System.out.println(new CheckSubarraySum().checkSubarraySum(new int[]{23,2,6,4,7},13));
        System.out.println(new CheckSubarraySum().checkSubarraySum(new int[]{5,0,0,0},3));
        System.out.println(new CheckSubarraySum().checkSubarraySum(new int[]{1,0},2));
    }
}
