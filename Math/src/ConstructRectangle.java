import java.util.Arrays;

public class ConstructRectangle {
    public int[] constructRectangle(int area) {
        int[] ans = {area, 1};
        int limit = (int) Math.sqrt(area);
        for (int i = area / 2; i >= limit; i--) {
            if (area % i == 0) {
                ans[0] = i;
                ans[1] = area / i;
            }
        }
        return new int[]{Math.max(ans[0], ans[1]), Math.min(ans[0], ans[1])};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(4)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(5)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(12)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(24)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(30)));
    }
}
