public class ReformatNumber {
    public String reformatNumber(String number) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if ('0' <= ch && ch <= '9') {
                temp.append(ch);
            }
        }
        int length = temp.length();

        int i = 0;
        StringBuilder ans = new StringBuilder();
        int yu = length % 3;
        if (yu == 1) {
            while (i < length-4) {
                ans.append(temp.charAt(i));
                if ((i + 1) % 3 == 0) {
                    ans.append("-");
                }
                i++;
            }
            ans.append(temp.substring(i, i + 2)).append("-").append(temp.substring(i + 2, i + 4));
        } else if (yu == 2) {
            while (i < length) {
                ans.append(temp.charAt(i));
                if ((i + 1) % 3 == 0) {
                    ans.append("-");
                }
                i++;
            }
        } else {
            while (i < length) {
                ans.append(temp.charAt(i));
                if ((i + 1) % 3 == 0) {
                    ans.append("-");
                }
                i++;
            }
            ans.deleteCharAt(ans.length()-1);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReformatNumber().reformatNumber("1-23-45 6"));
        System.out.println(new ReformatNumber().reformatNumber("123 4-567"));
        System.out.println(new ReformatNumber().reformatNumber("123 4-5678"));
    }
}
