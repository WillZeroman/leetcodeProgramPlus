import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Entity> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int[] data = mat[i];
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                if (data[j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            Entity entity = new Entity();
            entity.row = i;
            entity.value = data;
            entity.count = count;
            list.add(entity);
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.row - o2.row;
            } else {
                return o1.count - o2.count;
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Entity entity = list.get(i);
            ans[i] = entity.row;
        }
        return ans;
    }

    /**
     * 1,1,1,0,0,0,0
     * @param data
     * @return
     */
    public int count0(int[] data) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(data[mid] == 0){
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        return left;
    }

    class Entity {
        int row;
        int[] value;
        int count;
    }

    public static void main(String[] args) {
        System.out.println(new KWeakestRows().count0(new int[]{0,0,0}));
        System.out.println(new KWeakestRows().count0(new int[]{1,1,1,0,0,0}));
        System.out.println(new KWeakestRows().count0(new int[]{1,0,0,0,0}));
        System.out.println(new KWeakestRows().count0(new int[]{1,1,1,1,1}));
        System.out.println(new KWeakestRows().count0(new int[]{1}));
        System.out.println(new KWeakestRows().count0(new int[]{0}));
        System.out.println(new KWeakestRows().count0(new int[]{1,1}));
    }
}
