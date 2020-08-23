import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1) 回溯法
 * 巧妙避开了括号
 */
public class Point24 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int n : nums) {
            list.add((double) n);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.isEmpty()) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }
        // 选两个数字进行计算
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    LinkedList<Double> subList = new LinkedList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            subList.add(list.get(k));
                        }
                    }
                    double first = list.get(i);
                    double second = list.get(j);
                    // 四个运算符
                    // +
                    if (i < j) {
                        subList.add(first + second);
                        if (solve(subList)) {
                            return true;
                        }
                        subList.removeLast();
                    }
                    // -
                    subList.add(first - second);
                    if (solve(subList)) {
                        return true;
                    }
                    subList.removeLast();
                    // *
                    if (i < j) {
                        subList.add(first * second);
                        if (solve(subList)) {
                            return true;
                        }
                        subList.removeLast();
                    }
                    // /
                    if (second > 1e-6) {
                        subList.add(first / second);
                        if (solve(subList)) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2};
        System.out.println(new Point24().judgePoint24(nums));
    }
}
