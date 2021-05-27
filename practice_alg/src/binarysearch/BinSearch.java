package binarysearch;

public class BinSearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left)>>1);
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int mid = left + ((right - left)>>1);
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(new BinSearch().search(nums,9));
        System.out.println(new BinSearch().search(nums,2));
        System.out.println(new BinSearch().search(new int[]{5},1));
        System.out.println(new BinSearch().search(new int[]{5},5));
        System.out.println("------");
        System.out.println(new BinSearch().searchInsert(new int[]{1,3,5,6},5));
        System.out.println(new BinSearch().searchInsert(new int[]{1,3,5,6},2));
        System.out.println(new BinSearch().searchInsert(new int[]{1,3,5,6},7));
        System.out.println(new BinSearch().searchInsert(new int[]{1,3,5,6},0));
    }
}
