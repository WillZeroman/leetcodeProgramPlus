public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        if(s.length()<2){
            return 0;
        }
        int countL=0;
        int countR=0;
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L'){
                countL ++;
            }else{
                countR ++;
            }
            if(countL==countR&& countL!=0){
                ans ++;
                countR=0;
                countL=0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BalancedStringSplit().balancedStringSplit("LRLLRRLR"));
        System.out.println(new BalancedStringSplit().balancedStringSplit("LLLL"));
    }
}
