public class GenerateTheString {
    public String generateTheString(int n) {
        if (n % 2 == 0) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n-1; i++) {
                ans.append("a");
            }
            ans.append("b");
            return ans.toString();
        } else {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                ans.append("a");
            }
            return ans.toString();
        }

    }
}
