public class P1ThousandSep {
    public String thousandSeparator(int n) {
        String num = String.valueOf(n);
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = num.length() - 1; i >= 0; i--, count++) {
            if (count == 3) {
                res.insert(0, ".");
                count = 0;
            }
            res.insert(0, num.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P1ThousandSep().thousandSeparator(0));
        System.out.println(new P1ThousandSep().thousandSeparator(987));
        System.out.println(new P1ThousandSep().thousandSeparator(123456789));
        System.out.println(new P1ThousandSep().thousandSeparator(1234));
        System.out.println(new P1ThousandSep().thousandSeparator(54040));
    }
}
