public class P1isSumEqual {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        long first = convert(firstWord);
        long second = convert(secondWord);
        long target = convert(targetWord);
        return first +second == target;
    }
    private long convert(String word){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length();i++){
            sb.append(word.charAt(i)-'a');
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new P1isSumEqual().isSumEqual("aaa","a","aaaa"));
        System.out.println(new P1isSumEqual().isSumEqual("acb","cba","cdb"));
        System.out.println(new P1isSumEqual().isSumEqual("aaa","a","aab"));
    }
}
