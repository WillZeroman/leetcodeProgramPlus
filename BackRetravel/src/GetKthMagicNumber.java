import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        }
        int[] numbers = {3, 5, 7};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);
        k--;
        while (k-- > 0) {
            long item = queue.poll();
            for (int num : numbers) {
                long value = item * num;
                if (set.add(value)) {
                    queue.offer(value);
                }
            }
        }
        long ans = queue.poll();
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new GetKthMagicNumber().getKthMagicNumber(5));
        System.out.println(new GetKthMagicNumber().getKthMagicNumber(10));
        System.out.println(new GetKthMagicNumber().getKthMagicNumber(643));
    }
}
