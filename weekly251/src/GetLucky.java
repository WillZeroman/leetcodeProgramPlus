public class GetLucky {
    public int getLucky(String s, int k) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int num = s.charAt(i) - 'a' + 1;
            if(num>9){
                num = num /10 + num%10;
            }
            sum += num;
        }
        while(k>1){
            int tempSum = 0;
            while (sum>0){
                tempSum += sum%10;
                sum /=10;
            }
            sum = tempSum;
            k -- ;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new GetLucky().getLucky("iiii",1));
        System.out.println(new GetLucky().getLucky("leetcode",2));
        System.out.println(new GetLucky().getLucky("leetcode",1));
        System.out.println(new GetLucky().getLucky("a",1));
        System.out.println(new GetLucky().getLucky("a",2));
    }
}
