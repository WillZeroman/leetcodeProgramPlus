public class IntReverse {
    // not bad
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            int xx = Math.abs(x);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(xx));
            String reverse = stringBuilder.reverse().toString();
            try {
                int res = Integer.parseInt(reverse);
                return -res;
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        String reverse = stringBuilder.reverse().toString();
        try {
            int res = Integer.parseInt(reverse);
            return res;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int reverse_base(int x){
        int res = 0;
        while(x!=0){
            int pop = x %10;
            x /=10;
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            res = res * 10 + pop;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new IntReverse().reverse(123));
        System.out.println(new IntReverse().reverse(120));
        System.out.println(new IntReverse().reverse_base(-123));
        System.out.println(new IntReverse().reverse_base(1534236469));
        System.out.println(-1%9);
    }
}
