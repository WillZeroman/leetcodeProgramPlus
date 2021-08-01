public class MaximumNumber {
    public String maximumNumber(String num, int[] change) {
        StringBuilder ans = new StringBuilder();
        boolean isContinue=false;
        int i=0;
        for(;i<num.length();i++){
            char ch = num.charAt(i);
            int n = ch - '0';
            if(change[n]>=n){
                ans.append(change[n]);
                if(!isContinue&&change[n] == n){
                    continue;
                }
                isContinue = true;
            } else {
                ans.append(n);
                if(isContinue){
                    break;
                }
            }
        }
        if(i<num.length()-1){
            ans.append(num.substring(i+1));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumber().maximumNumber("5",new int[]{1,4,7,5,3,2,5,6,9,4}));
        System.out.println(new MaximumNumber().maximumNumber("021",new int[]{9,4,3,5,7,2,1,9,0,6}));
        System.out.println(new MaximumNumber().maximumNumber("132",new int[]{9,8,5,0,3,6,4,2,6,8}));
        //"334111"
        //[0,9,2,3,3,2,5,5,5,5]
        System.out.println(new MaximumNumber().maximumNumber("334111",new int[]{0,9,2,3,3,2,5,5,5,5}));
    }
}
