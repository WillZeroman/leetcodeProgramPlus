package chek;

import java.util.Arrays;

public class Checknums {
    public boolean check(int[] nums) {
        String rawStr = print(nums);
        String str2 = rawStr + rawStr;
        int[] copyNums = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copyNums);
        String copyStr = print(copyNums);
        System.out.println(str2);
        System.out.println(copyStr);
        return str2.contains(copyStr);
    }

    private String print(int[] nums){
        StringBuilder sb = new StringBuilder();
        for(int num:nums){
            sb.append(num).append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Checknums().check(new int[]{3,4,5,1,2}));
        System.out.println(new Checknums().check(new int[]{2,1,3,4}));
        System.out.println(new Checknums().check(new int[]{11,11,1,20}));
    }
}
