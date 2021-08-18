import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfWeeks {
    /**
     * 2,3,7,7,10
     * 2,7,7,10
     *
     * @param milestones
     * @return
     */
    public long numberOfWeeks(int[] milestones) {
        if(milestones.length == 1){
            return 1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        long sum = 0;
        for(int i=0;i<milestones.length;i++){
            queue.offer(milestones[i]);
            sum += milestones[i];
        }
        while (!queue.isEmpty()){
            int first = queue.poll();
            int second = queue.poll();
        }

        return -1;
    }
}
