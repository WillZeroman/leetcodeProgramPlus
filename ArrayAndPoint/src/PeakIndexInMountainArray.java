public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left =0;
        int right = arr.length-2;
        while (left<=right){
            int mid = left + (right - left) / 2;
            if (arr[mid]>arr[mid+1]) {
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new PeakIndexInMountainArray().peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(new PeakIndexInMountainArray().peakIndexInMountainArray(new int[]{1,2,3,2}));
    }
}
