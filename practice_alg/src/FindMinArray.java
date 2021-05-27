public class FindMinArray {
    public int minArray(int[] numbers) {
        for(int i=1;i<numbers.length;i++){
            if (numbers[i] < numbers[i-1]) {
                return numbers[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindMinArray().minArray(new int[]{3,4,5,1,2}));
        System.out.println(new FindMinArray().minArray(new int[]{2,2,2,0,1}));
    }
}
