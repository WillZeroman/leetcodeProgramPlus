public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int ans = 0;
        int maxValue = 1 << nums.length;
        for (int i = 0; i < maxValue; i++) {
            String tempStr = Long.toBinaryString(i);
            StringBuilder sb = new StringBuilder(tempStr);
            while (sb.length() < nums.length) {
                sb.insert(0, "0");
            }
            int sum = 0;
            for (int j = 0; j < sb.length(); j++) {
                char ch = sb.charAt(j);
                if (ch == '0') {
                    sum -= nums[j];
                } else {
                    sum += nums[j];
                }
            }
            if (sum == target) {
                ans++;
            }
        }

        return ans;
    }

    public int findTargetSumWays_best(int[] nums, int target) {
        int ans = 0;
        int maxValue = 1 << nums.length;
        for (int i = 0; i < maxValue; i++) {
            String tempStr = Long.toBinaryString(i);
            System.out.println(tempStr);
            int sum = 0;
            int start = nums.length - tempStr.length();
            for (int j = 0; j < nums.length; j++) {
                char ch = '0';
                if (j >= start) {
                    ch = tempStr.charAt(j-start);
                }
                if (ch == '0') {
                    sum -= nums[j];
                } else {
                    sum += nums[j];
                }
            }
            if (sum == target) {
                System.out.println("A " + tempStr);
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(new FindTargetSumWays().findTargetSumWays_best(new int[]{1, 1, 1,
        // 1, 1}, 3));
        System.out.println(new FindTargetSumWays().findTargetSumWays_best(new int[]{1, 0}, 1));
    }
}
