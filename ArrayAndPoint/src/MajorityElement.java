import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int split = len /3;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            int count = map.getOrDefault(num,0);
            count ++;
            map.put(num,count);
        }
        List<Integer> ans = new ArrayList<>();
        for (Integer key : map.keySet()){
            int value = map.get(key);
            if(value>split){
                ans.add(key);
            }
        }
        return ans;
    }
}

