public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        while(n>1){
            if(n % 2 !=0){
                return false;
            }
            n >>= 1;
        }
        return true;
    }
    // 位运算
    public boolean isPowerOfTwo_best(int n){
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(2));
        System.out.println(new PowerOfTwo().isPowerOfTwo(1));
        System.out.println(new PowerOfTwo().isPowerOfTwo(3));
        System.out.println(new PowerOfTwo().isPowerOfTwo(4));
        System.out.println(new PowerOfTwo().isPowerOfTwo(5));
    }
}
