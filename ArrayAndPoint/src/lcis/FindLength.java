package lcis;

public class FindLength {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int res = 0;
        int startIndex = 0;
        int i = 1;
        for(;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                continue;
            } else {
                res = Math.max(res,i - startIndex);
                startIndex = i;
            }
        }
        res = Math.max(res,i - startIndex);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindLength().findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(new FindLength().findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }
}
