import java.util.Arrays;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return valid(p1,p2,p3,p4) && valid(p2,p1,p3,p4) && valid(p3,p2,p1,p4) && valid(p4,p2,p3,p1);
    }

    private boolean valid(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d1 = distance(p1,p2);
        int d2 = distance(p1,p3);
        int d3 = distance(p1,p4);
        int[] array = new int[]{d1,d2,d3};
        Arrays.sort(array);
        return array[0]!=0 && array[0] == array[1] && array[0] * 2 == array[2];
    }

    private int distance(int[] p1,int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        //[0,0]
        //[1,1]
        //[1,0]
        //[0,1]
        System.out.println(new ValidSquare().validSquare(new int[]{0,0},new int[]{1,1},new int[]{1,0},new int[]{0,1}));
        //p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
        System.out.println(new ValidSquare().validSquare(new int[]{0,0},new int[]{1,1},new int[]{1,0},new int[]{0,12}));
        //p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
        System.out.println(new ValidSquare().validSquare(new int[]{1,0},new int[]{-1,0},new int[]{0,1},new int[]{0,-1}));
    }
}
