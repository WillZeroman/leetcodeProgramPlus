import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            set.add(i);
        }
        for (int num:nums){
            set.remove(num);
        }
        return new ArrayList<>(set).get(0);
    }

    public int missingNumber_bits(int[] nums) {
        int n = nums.length;
        BitSet bitSet = new BitSet(n);
        for(int num:nums){
            bitSet.set(num);
        }
        for(int i=0;i<bitSet.size();i++){
            if(!bitSet.get(i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber_bits(new int[]{0,1}));
        System.out.println(new MissingNumber().missingNumber_bits(new int[]{3,1,0}));
    }
}
