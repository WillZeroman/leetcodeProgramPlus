import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] letter = s.toCharArray();
        dfs(letter,0,ans);
        return ans;
    }

    private void dfs(char[] arr, int pos, List<String> ans) {
        while (pos < arr.length && Character.isDigit(arr[pos])) {
            pos++;
        }
        if (pos == arr.length) {
            ans.add(new String(arr));
            return;
        }
        arr[pos] ^= 32;
        dfs(arr, pos + 1, ans);
        arr[pos] ^= 32;
        dfs(arr, pos + 1, ans);
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2c3"));
    }
}
