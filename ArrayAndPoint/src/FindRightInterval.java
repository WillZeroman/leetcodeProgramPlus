import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindRightInterval {
    public int[] findRightInterval_bad(int[][] intervals) {
        List<Entity> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Entity entity = new Entity();
            entity.index = i;
            entity.start = intervals[i][0];
            entity.end = intervals[i][1];
            list.add(entity);
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.start<o2.end){
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(list);
        int[] ans = new int[intervals.length];
        for(int i=0;i<list.size()-1;i++){
            Entity entity = list.get(i);
            ans[entity.index] = list.get(i+1).index;
        }
        ans[list.get(list.size()-1).index] = -1;
        return ans;
    }

    class Entity {
        int index;
        int start;
        int end;

        @Override
        public String toString() {
            return "Entity{" +
                    "index=" + index +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, (o1, o2) -> o1[0] - o2[0]);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    target = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindRightInterval().findRightInterval(new int[][]{{3,4},{2,3},{1,2}})));
    }
}
