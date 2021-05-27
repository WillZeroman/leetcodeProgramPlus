import java.util.LinkedList;
import java.util.List;

public class ArrayForm {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new LinkedList<>();
        int plus = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int num = A[i] + K % 10 + plus;
            K /= 10;
            if (num >= 10) {
                plus = 1;
                num -= 10;
            } else {
                plus = 0;
            }
            result.add(0, num);
        }
        while (K > 0) {
            int num = K%10 + plus;
            if (num >= 10) {
                plus = 1;
                num -= 10;
            } else {
                plus = 0;
            }
            result.add(0, num);
            K /= 10;
        }
        if (plus == 1) {
            result.add(0, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayForm().addToArrayForm(new int[]{1, 2, 0, 0}, 56));
        System.out.println(new ArrayForm().addToArrayForm(new int[]{9, 9, 9, 9}, 2));
        System.out.println(new ArrayForm().addToArrayForm(new int[]{0}, 23));
        System.out.println(new ArrayForm().addToArrayForm(new int[]{6}, 809));
    }
}
