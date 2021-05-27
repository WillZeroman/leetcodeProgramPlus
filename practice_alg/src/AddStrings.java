public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j =num2.length()-1;
        int plus = 0;
        StringBuilder res = new StringBuilder();
        while(i>=0&& j>=0){
            int first = num1.charAt(i) - '0';
            int second = num2.charAt(j) - '0';
            int sum = first + second + plus;
            plus = sum/10;
            sum %=10;
            res.insert(0,sum);
            i--;
            j--;
        }
        while(i>=0){
            int num = num1.charAt(i) - '0';
            int sum = num + plus;
            plus = sum/10;
            sum %=10;
            res.insert(0,sum);
            i--;
        }
        while(j>=0){
            int num = num2.charAt(j) - '0';
            int sum = num + plus;
            plus = sum/10;
            sum %=10;
            res.insert(0,sum);
            j--;
        }
        if(plus>0){
            res.insert(0,plus);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("9999","1"));
        System.out.println(new AddStrings().addStrings("1000","99"));
    }
}
