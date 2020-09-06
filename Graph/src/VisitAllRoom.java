import java.util.*;

public class VisitAllRoom {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        ArrayDeque<Integer> queue = new ArrayDeque();
        Set<Integer> visitedSets = new HashSet<>();
        queue.offer(0);
        visitedSets.add(0);
        while (!queue.isEmpty() && visitedSets.size() < len) {
            int room = queue.poll();
            List<Integer> nextRooms = rooms.get(room);
            nextRooms.forEach((nextRoom) -> {
                if (!visitedSets.contains(nextRoom)) {
                    queue.offer(nextRoom);
                    visitedSets.add(nextRoom);
                }
            });
        }
        return visitedSets.size() == len;
    }
}
