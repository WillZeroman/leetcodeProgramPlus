import java.util.Arrays;

public class MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int ans = 0;
        int count = 0;
        for (int[] box : boxTypes) {
            if (count + box[0] <= truckSize) {
                ans += box[0] * box[1];
                count += box[0];
            } else {
                int dif = truckSize - count;
                ans += dif * box[1];
                break;
            }
        }
        return ans;
    }
}
