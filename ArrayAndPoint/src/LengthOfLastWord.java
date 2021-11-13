public class LengthOfLastWord {
    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if(s.length()==0){
            return 0;
        }
        int ans = 0;
        int start = 0;
        int i=0;
        for(i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                int len = i - start;
                if(len >0){
                    ans = len;
                }
                start = i+1;
            }
        }
        int len = i - start;
        if(len >0){
            ans = len;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Today is a nice day"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  "));
    }
}
