import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        List<Entity> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Entity entity = new Entity();
            entity.index = i;
            entity.num = arr[i];
            list.add(entity);
        }
        Collections.sort(list, (o1, o2) -> o1.num - o2.num);
        int[] ans = new int[arr.length];
        int count = 1;
        int preNum = list.get(0).num;
        ans[list.get(0).index] = count;
        for (int i = 1; i < list.size(); i++) {
            Entity current = list.get(i);
            if (current.num != preNum) {
                count++;
                preNum = current.num;
            }
            ans[current.index] = count;
        }
        return ans;
    }

    private class Entity {
        int num;
        int index;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ArrayRankTransform().arrayRankTransform(new int[]{100,100,100})));
        System.out.println(Arrays.toString(new ArrayRankTransform().arrayRankTransform(new int[]{40,10,20,30})));
    }
}
