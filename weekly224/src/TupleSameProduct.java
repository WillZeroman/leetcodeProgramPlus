import java.util.HashMap;
import java.util.Map;

public class TupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> tupleSumMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum = nums[i] * nums[j];
                if(tupleSumMap.containsKey(sum)){
                    tupleSumMap.put(sum,tupleSumMap.get(sum) + 1);
                }else {
                    tupleSumMap.put(sum,1);
                }
            }
        }
        int count =0 ;
        for(Integer key : tupleSumMap.keySet()){
            int value = tupleSumMap.get(key);
            if(value > 1) {
                int tmpCount = value * (value-1) / 2;
                count +=tmpCount;
            }
        }
        return count * 8;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,10};
        System.out.println(new TupleSameProduct().tupleSameProduct(nums));
        System.out.println(new TupleSameProduct().tupleSameProduct(new int[]{2,3,4,6,8,12}));
        int i = 10000 * 10000;
        System.out.println(i);
    }
}
