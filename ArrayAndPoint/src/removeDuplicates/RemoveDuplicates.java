package removeDuplicates;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int dupCount = 0;
        int preValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == preValue) {
                dupCount ++;
            } else {
                preValue = nums[i];
                nums[i - dupCount] = nums[i];
            }
        }

        return nums.length - dupCount;
    }

    public int removeDuplicates_two(int[] nums) {
        int ans = 0;
        int dupCount = 1;
        int preValue = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == preValue){
                dupCount ++;
                if(dupCount > 2){
                    // remove
                    ans ++;
                    dupCount = 2;
                } else {
                    nums[i-ans] = nums[i];
                }
            } else {
                preValue = nums[i];
                dupCount = 1;
                nums[i-ans] = nums[i];
            }
        }

        return nums.length - ans;
    }

    public static void main(String[] args) {
        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {1,1,2};
        int len = new RemoveDuplicates().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
