public class GetMaximumGenerated {

    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i >> 1];
            } else {
                int half = i >> 1;
                arr[i] = arr[half] + arr[half + 1];
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new GetMaximumGenerated().getMaximumGenerated(7));
        System.out.println(new GetMaximumGenerated().getMaximumGenerated(2));
        System.out.println(new GetMaximumGenerated().getMaximumGenerated(3));
    }
}
