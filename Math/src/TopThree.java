import java.util.*;

public class TopThree {

    /**
     * 最大3个数和最小2个数
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int[] topNums = new int[3];
        topNums[0] = nums[0];
        topNums[1] = nums[1];
        topNums[2] = nums[2];
        Arrays.sort(topNums);

        for(int i=3;i<nums.length;i++){
            int tempNum = nums[i];
            if(tempNum > topNums[0]){
                topNums[0] = tempNum;
                for(int j=1;j<topNums.length;j++){
                    if(topNums[1]<topNums[0]){
                        //swap
                        int temp = topNums[j-1];
                        topNums[j-1] = topNums[j];
                        topNums[j] = temp;
                    }
                }
            }
        }
        int sum =1;
        for(int i=0;i<topNums.length;i++){
            sum *= topNums[i];
        }
        return sum;
    }

    public int maximumProduct_correct(int[] nums){
        Arrays.sort(nums);
        int sumTopThree = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        int sumTopOneAndNev = nums[0] * nums[1] * nums[nums.length-1];
        return Math.max(sumTopThree,sumTopOneAndNev);
    }

    public static void main(String[] args) {
        System.out.println(new TopThree().maximumProduct(new int[]{1,2,3}));
        System.out.println(new TopThree().maximumProduct(new int[]{1,2,3,4}));
        System.out.println(new TopThree().maximumProduct(new int[]{1,2,3,5,6}));
        System.out.println(new TopThree().maximumProduct_correct(new int[]{1,2,3,5,6}));
        System.out.println(new TopThree().maximumProduct(new int[]{1,2,3,-100,-99}));
        System.out.println(new TopThree().maximumProduct_correct(new int[]{1,2,3,-100,-99}));
    }
}
