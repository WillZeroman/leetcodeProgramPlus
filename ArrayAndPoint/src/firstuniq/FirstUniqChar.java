package firstuniq;

import java.util.Arrays;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        int[] numIndex = new int[26];
        Arrays.fill(numIndex, -1);
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (numIndex[index] == -1) {
                numIndex[index] = i;
            } else {
                numIndex[index] = len;
            }
        }
        int res = len;
        for (int num : numIndex) {
            if (num !=-1 && res > num) {
                res = num;
            }
        }
        return res == len ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar(""));
        System.out.println(new FirstUniqChar().firstUniqChar("leetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar("loveleetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar("aabbcc"));
    }
}
