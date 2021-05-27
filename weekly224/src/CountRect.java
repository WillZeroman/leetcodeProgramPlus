import java.util.HashMap;
import java.util.Map;

public class CountRect {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer,Integer> maxLenMap = new HashMap<>();
        for(int i=0;i<rectangles.length;i++){
            int[] tempRect = rectangles[i];
            int key = Math.min(tempRect[0],tempRect[1]);
            if(maxLenMap.containsKey(key)){
                maxLenMap.put(key,maxLenMap.get(key)+1);
            }else {
                maxLenMap.put(key,1);
            }
        }
        int maxKey = 0;
        for(Integer key : maxLenMap.keySet()){
            maxKey = Math.max(key,maxKey);
        }
        return maxLenMap.get(maxKey);
    }

    public static void main(String[] args) {
        //[[5,8],[3,9],[5,12],[16,5]]
        int[][] rects = {{5,8},{3,9},{5,12},{16,5}};
        System.out.println(new CountRect().countGoodRectangles(rects));
    }
}
