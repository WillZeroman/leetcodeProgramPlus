package roman;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return romanMap.get(s.charAt(0));
        }
        int num = 0;
        boolean last = false;
        for (int i = 1; i < s.length(); i++) {
            char first = s.charAt(i - 1);
            char second = s.charAt(i);
            if (romanMap.get(first) >= romanMap.get(second)) {
                num += romanMap.get(first);
                last = false;
            } else {
                int tempValue = romanMap.get(second) - romanMap.get(first);
                num += tempValue;
                i++;
                last = i>=s.length();
            }
        }
        if (!last) {
            num += romanMap.get(s.charAt(s.length() - 1));
        }
        return num;
    }

    public static void main(String[] args) {
//        System.out.println(new RomanToInt().romanToInt("III"));
//        System.out.println(new RomanToInt().romanToInt("IV"));
//        System.out.println(new RomanToInt().romanToInt("IX"));
//        System.out.println(new RomanToInt().romanToInt("LVIII"));
        System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
        System.out.println(new RomanToInt().romanToInt("MDCXCV"));
    }
}
