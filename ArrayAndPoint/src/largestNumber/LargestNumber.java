package largestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    // error
    public String largestNumber(int[] nums) {
        List<NumEntity> list = new ArrayList<>();
        for (int num : nums) {
            NumEntity entity = new NumEntity();
            entity.val = num;
            list.add(entity);
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.val == o2.val){
                return 0;
            }
            String v1 = o1.val + "";
            String v2 = o2.val + "";
            int len = Math.max(v1.length(), v2.length());

            for (int i = 0; i < len; i++) {
                int i1 = (i + v1.length()) % v1.length();
                int i2 = (i + v2.length()) % v2.length();
                char c1 = v1.charAt(i1);
                char c2 = v2.charAt(i2);
                if (c1 == c2) {
                    continue;
                } else {
                    return c2 - c1;
                }
            }
            return 0;
        });
        System.out.println(list);
        StringBuilder ans = new StringBuilder();
        for (NumEntity entity : list) {
            ans.append(entity.val);
        }
        return ans.toString();
    }

    public String largestNumber_best(int[] nums) {
        List<NumEntity> list = new ArrayList<>();
        for (int num : nums) {
            NumEntity entity = new NumEntity();
            entity.val = num;
            list.add(entity);
        }
        Collections.sort(list, (o1, o2) -> {
            String v1 = o1.val+"";
            String v2 = o2.val+"";
            return -(v1+v2).compareTo(v2+v1);
        });
        System.out.println(list);
        if(list.get(0).val == 0){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (NumEntity entity : list) {
            ans.append(entity.val);
        }
        return ans.toString();
    }

    class NumEntity {
        int val;

        @Override
        public String toString() {
            return "NumEntity{" +
                    "val=" + val +
                    '}';
        }
    }


    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber_best(new int[]{10, 2}));
        System.out.println(new LargestNumber().largestNumber_best(new int[]{3, 330, 34, 5, 9}));
        //[34323,3432]
        System.out.println(new LargestNumber().largestNumber_best(new int[]{34323,3432}));
    }
}
