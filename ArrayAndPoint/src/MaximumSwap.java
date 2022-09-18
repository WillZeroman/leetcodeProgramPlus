public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIdx = n - 1;
        int idx1 = -1, idx2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (charArray[i] > charArray[maxIdx]) {
                maxIdx = i;
            } else if (charArray[i] < charArray[maxIdx]) {
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        if (idx1 >= 0) {
            swap(charArray, idx1, idx2);
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }
    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
    public static void main(String[] args) {
//        System.out.println(new MaximumSwap().maximumSwap(2736));
//        System.out.println(new MaximumSwap().maximumSwap(9973));
//        System.out.println(new MaximumSwap().maximumSwap(9937));
//        System.out.println(new MaximumSwap().maximumSwap(9937123));
//        System.out.println(new MaximumSwap().maximumSwap(115));
        System.out.println(new MaximumSwap().maximumSwap(11));
    }
}
