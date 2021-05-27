package array;

/**
 * 滑动窗口，双指针
 */
public class LongestOnes {

    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, max = 0;
        int count0 = 0;
        for (; right < A.length; right++) {
            if (A[right] == 0) {
                count0++;
            }
            if (count0 > K) {
                if (A[left] == 0) {
                    count0--;
                }
                left++;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestOnes().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(new LongestOnes().longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
