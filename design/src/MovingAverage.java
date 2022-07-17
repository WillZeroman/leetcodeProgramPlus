import java.util.ArrayDeque;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    private Queue<Integer> queue;

    private int sum;

    private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque<>(size);
        this.size = size;
    }

    public double next(int val) {
        if(queue.size() == size){
            int first = queue.poll();
            sum -= first;
        }
        queue.offer(val);
        sum += val;
        return  ((double) sum) / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage average = new MovingAverage(3);
        System.out.println(average.next(1));
        System.out.println(average.next(10));
        System.out.println(average.next(3));
        System.out.println(average.next(5));
        new Date();
    }
}
