package longestSubarray;

import java.util.Deque;
import java.util.LinkedList;

public class LongestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> queMax = new LinkedList<Integer>();
        Deque<Integer> queMin = new LinkedList<Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubarray().longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(new LongestSubarray().longestSubarray(new int[]{10,1,2,4,7,2}, 5));
        System.out.println(new LongestSubarray().longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }
}
