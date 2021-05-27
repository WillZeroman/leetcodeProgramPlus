public class XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorArr = new int[arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
            xorArr[i] = res;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (left == right) {
                ans[i] = arr[left];
            } else {
                if (left == 0) {
                    ans[i] = xorArr[right];
                } else {
                    ans[i] = xorArr[left - 1] ^ xorArr[right];
                }
            }
        }
        return ans;
    }
}
