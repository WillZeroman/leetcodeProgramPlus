package smallest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 图的连通性
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.isEmpty()){
            return s;
        }
        return "";
    }

    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));
        pairs.add(Arrays.asList(0,2));
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("dcab",pairs));
    }
}
