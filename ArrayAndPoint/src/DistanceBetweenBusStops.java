public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        return Math.min(distance(distance,start,destination),distance(distance,destination,start));
    }
    private int distance(int[] distance,int start, int destination){
        int len = distance.length;
        int cursor = start;
        int sum = 0;
        while (cursor != destination) {
            sum += distance[cursor];
            cursor ++;
            cursor %= len;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new DistanceBetweenBusStops().distanceBetweenBusStops(new int[]{1,2,3,4},0,3));
    }

}
