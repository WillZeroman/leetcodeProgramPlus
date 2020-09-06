/**
 * 判断字符串是否为数字
 */
public class IsNumber {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        char last = s.charAt(s.length() - 1);
        if (last == 'f' || last == 'F' || last == 'D' || last == 'd') {
            return false;
        }
        boolean result = false;
        try {
            Double.parseDouble(s);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new IsNumber().isNumber("+100"));
        System.out.println(new IsNumber().isNumber("3.1416"));
        System.out.println(new IsNumber().isNumber("-1E-16"));
        System.out.println(new IsNumber().isNumber("+-5"));
        System.out.println(new IsNumber().isNumber("959440.94f"));
        System.out.println(new IsNumber().isNumber("84656e656D"));
        System.out.println(new IsNumber().isNumber("84656e656F"));
    }
}
