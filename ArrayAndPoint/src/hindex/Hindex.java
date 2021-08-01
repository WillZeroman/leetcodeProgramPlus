package hindex;

import java.util.Arrays;

public class Hindex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int h = 0;
        int i= citations.length-1;
        while(i>=0 && citations[i]>h){
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(new Hindex().hIndex(new int[]{3,0,6,1,5}));
    }
}
