import java.util.ArrayList;
import java.util.List;

public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int listValue = 1;
        for (int i = 0; i < target.length; i++) {
            int num = target[i];
            if (num != listValue) {
                for (int j = listValue; j < num; j++) {
                    ans.add("Push");
                    ans.add("Pop");
                }
                listValue = num;
            }
            ans.add("Push");
            listValue++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BuildArray().buildArray(new int[]{1,3},3));
        System.out.println(new BuildArray().buildArray(new int[]{1,2,3},3));
        System.out.println(new BuildArray().buildArray(new int[]{1,2,5},5));
    }
}
