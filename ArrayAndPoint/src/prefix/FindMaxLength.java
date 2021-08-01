package prefix;

import java.util.HashMap;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        if(nums.length <2){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                sum ++;
            } else {
                sum --;
            }
            if (map.containsKey(sum)) {
                int index = map.get(sum);
                maxLength = Math.max(maxLength,i-index);
            } else {
                map.put(sum,i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new FindMaxLength().findMaxLength(new int[]{0,1}));
    }
}
