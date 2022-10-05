import java.util.HashMap;
import java.util.Map;

public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] arrs : pieces) {
            map.put(arrs[0], arrs);
        }
        for (int i = 0; i < arr.length;) {
            int num = arr[i];
            if (!map.containsKey(num)) {
                return false;
            }
            int[] arrs = map.get(num);
            for (int j = 0; j < arrs.length; j++) {
                if (arrs[j] != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanFormArray().canFormArray(new int[]{15,88},new int[][]{{88},{15}}));
    }
}
