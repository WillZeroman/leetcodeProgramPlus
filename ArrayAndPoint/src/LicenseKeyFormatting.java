public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                len++;
            }
        }
        if(len ==0){
            return "";
        }
        int firstNum = len % k;
        StringBuilder res = new StringBuilder();
        int count = 0;
        int i = 0;
        while (count < firstNum) {
            char ch = s.charAt(i);
            i++;
            if (ch != '-') {
                res.append(Character.toUpperCase(ch));
                count++;
            }
        }
        if (firstNum > 0) {
            res.append('-');
            count = 0;
        }
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '-') {
                res.append(Character.toUpperCase(ch));
                count++;
                if (count >= k) {
                    res.append("-");
                    count = 0;
                }
            }
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("--a-", 3));
    }
}
