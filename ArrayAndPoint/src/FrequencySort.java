import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Entity> map = new HashMap<>();
        for (int num : nums) {
            Entity entity = map.getOrDefault(num, new Entity());
            entity.num = num;
            entity.count += 1;
            map.put(num,entity);
        }
        List<Entity> list = new ArrayList<>(map.values());
        Collections.sort(list, (o1, o2) -> o1.count == o2.count ? o2.num - o1.num :
                o1.count - o2.count);
        int[] ans = new int[nums.length];
        int index = 0;
        for (Entity entity : list) {
            Arrays.fill(ans, index, index + entity.count, entity.num);
            index += entity.count;
        }
        return ans;
    }

    class Entity {
        int num;
        int count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FrequencySort().frequencySort(new int[]{1,1,2,2,2,3})));
        System.out.println(Arrays.toString(new FrequencySort().frequencySort(new int[]{2,3,1,3,2})));
        System.out.println(Arrays.toString(new FrequencySort().frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1})));
    }
}
