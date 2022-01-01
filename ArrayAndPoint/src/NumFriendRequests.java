import java.util.Arrays;

public class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        for (int i = 0; i < ages.length; i++) {
            int start = 0;
            int end = i-1;
            while (start<=end){
                int mid = (start+end)/2;
                if(check(ages,mid,i)){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
            ans += (i-start);
            if(ages[i]<15){
                continue;
            }
            int j = i+1;
            while (j<ages.length){
                if(ages[i]==ages[j]){
                    ans ++;
                    j++;
                }else {
                    break;
                }
            }
        }
        return ans;
    }
    private boolean check(int[] ages, int target, int src)
    {
        if(ages[target] <= (ages[src]/2+7)){
            return false;
        }
        if(ages[target]>100 && ages[src]<100){
            return false;
        }
        return true;
    }

    public int numFriendRequests_best(int[] ages){
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new NumFriendRequests().numFriendRequests(new int[]{73,106,39,6,26,15,30,100,71,35,46,112,6,60,110}));
    }
}
