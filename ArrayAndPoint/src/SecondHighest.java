public class SecondHighest {
    public int secondHighest(String s) {
        int[] nums = {-1, -1};
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                if (num > nums[0]) {
                    nums[1] = nums[0];
                    nums[0] = num;
                } else if (num < nums[0]) {
                    if(num > nums[1]){
                        nums[1] = num;
                    }
                }
            }
        }
        return nums[1];
    }

    public static void main(String[] args) {
        System.out.println(new SecondHighest().secondHighest("dfa12321afd"));
        System.out.println(new SecondHighest().secondHighest("abc1111"));
        System.out.println(new SecondHighest().secondHighest("abcasdf"));
        System.out.println(new SecondHighest().secondHighest("abca1212sdf"));
    }
}
