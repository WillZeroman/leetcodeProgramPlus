public class P1ThreeOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int consecutiveoddNum = 0;
        for (int i = 0; i < arr.length && consecutiveoddNum < 3; i++) {
            if (arr[i] % 2 == 1) {
                consecutiveoddNum++;
            } else {
                consecutiveoddNum = 0;
            }
        }
        return consecutiveoddNum == 3;
    }

    public static void main(String[] args) {
        int[] arr = {2,6,4,1};
        System.out.println(new P1ThreeOdds().threeConsecutiveOdds(arr));
        int[] arr1 = {1,2,34,3,4,5,7,23,12};
        System.out.println(new P1ThreeOdds().threeConsecutiveOdds(arr1));
    }
}
