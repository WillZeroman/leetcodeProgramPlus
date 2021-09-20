public class ReverseVowels {
    public String reverseVowels(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        int left = 0;
        int right = s.length()-1;
        char[] arr = s.toCharArray();
        while(left<right){
            while(left<right&&!isVowel(s.charAt(left))){
                left ++;
            }
            while(left<right&&!isVowel(s.charAt(right))){
                right --;
            }
            if(left < right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left ++;
                right --;
            }
        }
        return new String(arr);
    }
    private boolean isVowel(char ch){
        return "aeiouAEIOU".contains(String.valueOf(ch));
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("hello"));
        System.out.println(new ReverseVowels().reverseVowels("leetcode"));
    }
}
