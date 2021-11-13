import java.util.Arrays;

public class ToMax {
    public String toHex(int num) {
        char[] digit = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num == 0){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 7; i >=0 ; i--) {
            int val = (num >> (4*i)) & 0xf;
            if(res.length()>0||val>0){
                res.append(digit[val]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ToMax().toHex(26));
        System.out.println(new ToMax().toHex(-1));
        System.out.println(new ToMax().toHex(-4));
        System.out.println(new ToMax().toHex(-2147483648));
    }
}
