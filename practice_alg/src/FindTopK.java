import java.util.Arrays;

public class FindTopK {
    // 堆
    public int findKthLargest(int[] nums, int k) {
        if(k == 1){
            // find max;

        }
        int len = nums.length;
        if(k >= (len >> 1)){
            // find top largest K
            int[] topK = Arrays.copyOf(nums,k);
            adjustHeap(topK);
            for (int i=k;i<nums.length;i++) {
                if (nums[i] >= topK[0]) {
                    topK[0] = nums[i];
                    adjustHeap(topK);
                }
            }
            return topK[0];
        } else {
            // find top smallest len - K +1;
            k = len - k + 1;

        }
        //
        return -1;
    }

    private void adjustHeap(int[] arr) {
        int index = arr.length / 2 -1;
        if(index>0) {
            for(int i=index;i>=0;i--){
                if(arr[i]> arr[i*2+1]){

                }
            }
        }
    }

    public int findKthLargest_bad(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        System.out.println(new FindTopK().findKthLargest_bad(new int[]{3,2,3,1,2,4,5,5,6},4));
        System.out.println(new FindTopK().findKthLargest_bad(new int[]{3,2,1,5,6,4},2));
    }
}
