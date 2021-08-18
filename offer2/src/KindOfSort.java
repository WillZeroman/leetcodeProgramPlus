import java.util.Arrays;

public class KindOfSort {
    public void quickSort(int[] data) {
        quick(data, 0, data.length - 1);
    }

    private void quick(int[] data, int i, int j) {
        if (i < j) {
            int index = partition(data, i, j);
            quick(data, i, index - 1);
            quick(data, index + 1, j);
        }
    }


    private int partition(int[] data, int i, int j) {
        int flag = data[i];
        while (i < j) {
            while (data[j] >= flag && i < j) {
                j--;
            }
            data[i] = data[j];
            while (data[i] <= flag && i < j) {
                i++;
            }
            data[j] = data[i];
        }
        data[i] = flag;
        System.out.println(i);
        return i;
    }

    public static void main(String[] args) {
        // 1,3,5,7,9,2,4,6,8;
        int[] data = {1, 3, 5, 7, 9};
        new KindOfSort().quickSort(data);
        System.out.println(Arrays.toString(data));
    }
}
