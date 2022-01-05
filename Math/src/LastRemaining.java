public class LastRemaining {
    public int lastRemaining(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) { // 正向
                a1 = a1 + step;
            } else { // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().lastRemaining(9));
        System.out.println(new LastRemaining().lastRemaining(1));
    }
}
