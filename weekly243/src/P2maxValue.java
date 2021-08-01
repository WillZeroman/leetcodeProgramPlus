import java.nio.charset.StandardCharsets;

public class P2maxValue {
    public String maxValue(String n, int x) {
        StringBuilder ans = new StringBuilder(n);
        if(n.startsWith("-")){
            int i=1;
            for(i=1;i<n.length();i++){
                char ch = n.charAt(i);
                int num = ch - '0';
                if(num>x){
                    break;
                }
            }
            ans.insert(i,x);
        } else {
            int i=0;
            for(i=0;i<n.length();i++){
                char ch = n.charAt(i);
                int num = ch - '0';
                if(num<x){
                    break;
                }
            }
            ans.insert(i,x);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P2maxValue().maxValue("99",9));
        System.out.println(new P2maxValue().maxValue("-13",2));
    }
}
