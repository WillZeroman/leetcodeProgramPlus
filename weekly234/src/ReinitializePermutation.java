import java.util.Arrays;

public class ReinitializePermutation {

    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
        }
        int count = 0;
        int[] arr = Arrays.copyOf(perm, perm.length);
        while (true) {
            // step 1
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            // count ++
            count++;
            //check valid
            if (checkValid(arr)) {
                break;
            }

            // new perm
            perm = Arrays.copyOf(arr, arr.length);
        }
        return count;
    }

    private boolean checkValid(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ReinitializePermutation().reinitializePermutation(2));
        System.out.println(new ReinitializePermutation().reinitializePermutation(4));
        System.out.println(new ReinitializePermutation().reinitializePermutation(6));
    }
}
