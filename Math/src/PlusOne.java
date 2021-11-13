import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return digits;
        }

        int last = digits.length - 1;
        digits[last] += 1;
        int plus = digits[last] / 10;
        digits[last] %= 10;
        for (int i = digits.length - 2; i >= 0 && plus > 0; i--) {
            digits[i] = digits[i] + plus;
            plus = digits[i] / 10;
            digits[i] %= 10;
        }

        if (plus > 0) {
            int[] ans = new int[digits.length + 1];
            System.arraycopy(digits, 0, ans, 1, digits.length);
            ans[0] = plus;
            return ans;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{8})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9, 9, 9})));
    }
}
