public class IsThree {
    public boolean isThree(int n) {
        double div = Math.sqrt(n);
        int intDiv = (int) div;
        if(intDiv == div){
            if(prime(intDiv) && intDiv!=n){
                return true;
            }
        }
        return false;
    }

    private boolean prime(int n){
        for(int i=2;i<n/2;i++){
            if(n %i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsThree().isThree(2));
        System.out.println(new IsThree().isThree(4));
        System.out.println(new IsThree().isThree(1));
        System.out.println(new IsThree().isThree(169));
        System.out.println(new IsThree().isThree(100));
    }
}
