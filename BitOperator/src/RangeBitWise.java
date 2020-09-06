/**
 * 给定两个整数，我们要找到它们对应的二进制字符串的公共前缀
 *
 * m 到 n 按位与的值
 *
 * 1)考虑 m =0
 * 2) m = n
 * 3) m 与 n 二进制长度不一样
 * 4） m 与 n 长度一样
 */
public class RangeBitWise {

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        if (m == n) {
            return m;
        }
        String bm = Integer.toBinaryString(m);
        String bn = Integer.toBinaryString(n);
        if (bm.length() != bn.length()) {
            return 0;
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (; i < bm.length(); i++) {
            if (bn.charAt(i) == bm.charAt(i)) {
                res.append(bn.charAt(i));
            } else {
                break;
            }
        }
        while (i < bm.length()) {
            res.append("0");
            i++;
        }
        return Integer.parseInt(res.toString(), 2);
    }

    /**
     * 找到公共前缀
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd1(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    public static void main(String[] args) {
//        System.out.println(new RangeBitWise().rangeBitwiseAnd(7, 10));
        System.out.println(new RangeBitWise().rangeBitwiseAnd1(5, 7));
//        System.out.println(new RangeBitWise().rangeBitwiseAnd(0, 1));
        System.out.println(new RangeBitWise().rangeBitwiseAnd(2147483646, 2147483647));
    }
}
