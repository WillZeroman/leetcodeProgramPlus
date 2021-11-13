public class FindComplement {
    public int findComplement(int num) {
       String str = Integer.toString(num,2);
       StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '0'){
                ans.append(1);
            }else {
                ans.append(0);
            }
        }
        return Integer.parseInt(ans.toString(),2);
    }

    public static void main(String[] args) {
        System.out.println(new FindComplement().findComplement(5));
        System.out.println(new FindComplement().findComplement(2));
    }
}
