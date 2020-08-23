package smallestrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 给定 k 个数组，求最小区间
 */
public class SmallestRange {

    /**
     * 每个数组一个指针，然后遍历
     *
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        // null
        if (nums == null || nums.isEmpty()) {
            return new int[0];
        }
        // remove empty
        Iterator<List<Integer>> it = nums.iterator();
        while (it.hasNext()) {
            List<Integer> list = it.next();
            if (list.isEmpty()) {
                it.remove();
            }
        }
        int k = nums.size();
        int[] points = new int[k];
        Arrays.fill(points, 0);
        int[] result = {0, 0};
        boolean end = false;
        int minIndex = -1;
        int distance = Integer.MAX_VALUE;
        do {
            // 每次排序，可以优化为 小顶堆
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                List<Integer> tempList = nums.get(i);
                int tempNum = tempList.get(points[i]);
                if (tempNum < min) {
                    min = tempNum;
                    minIndex = i;
                }
                if (tempNum > max) {
                    max = tempNum;
                }
            }
            int tempDis = max - min;
            if (tempDis < distance) {
                distance = tempDis;
                result = new int[]{min, max};
            }
            // 最小值 ++
            points[minIndex] = points[minIndex] + 1;
            if (nums.get(minIndex).size() <= points[minIndex]) {
                end = true;
            }
        } while (!end);

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5));
        nums.add(new ArrayList<>());
        int[] result = new SmallestRange().smallestRange(nums);
        System.out.println(Arrays.toString(result));
    }
}
