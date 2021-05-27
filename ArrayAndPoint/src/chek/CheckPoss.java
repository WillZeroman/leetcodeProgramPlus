package chek;

public class CheckPoss {
    public boolean checkPossibility(int[] nums) {
        boolean res = true;
        boolean hasChange = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                if (hasChange) {
                    res = false;
                    break;
                }
                hasChange = true;
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CheckPoss().checkPossibility(new int[]{4, 2, 3}));
        System.out.println(new CheckPoss().checkPossibility(new int[]{4, 2, 1}));
        System.out.println(new CheckPoss().checkPossibility(new int[]{4}));
        System.out.println(new CheckPoss().checkPossibility(new int[]{2, 3, 5}));
        System.out.println(new CheckPoss().checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(new CheckPoss().checkPossibility(new int[]{2, 3, 2, 1}));
    }
}
