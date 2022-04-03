import java.util.HashMap;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int preIndex = map.get(nums[i]);
                if (i-preIndex<=k) {
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1,2,3,1},3));
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }
}
