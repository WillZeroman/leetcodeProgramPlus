import java.util.HashMap;

public class FindLHS {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums){
            int count = map.getOrDefault(num,0);
            map.put(num,count+1);
        }
        int ans = 0;
        for (int key:map.keySet()){
            int val = map.get(key);
            if(map.containsKey(key+1)){
                ans = Math.max(ans,val+map.get(key+1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindLHS().findLHS(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(new FindLHS().findLHS(new int[]{1,2,3,4}));
        System.out.println(new FindLHS().findLHS(new int[]{1,1,1,1}));
    }
}
