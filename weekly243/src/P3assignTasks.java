import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;

public class P3assignTasks {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<ServerEntity> idleQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o1.index - o2.index;
            } else {
                return o1.weight - o2.weight;
            }
        });
        for (int i = 0; i < servers.length; i++) {
            ServerEntity serverEntity = new ServerEntity();
            serverEntity.index = i;
            serverEntity.weight = servers[i];
            idleQueue.add(serverEntity);
        }
        System.out.println(idleQueue);
        LinkedList<ServerEntity> runningServers = new LinkedList<>();
        int[] ans = new int[tasks.length];
        int time = 0;
        int taskIndex = 0;
        while (taskIndex < tasks.length) {
            // visit running servers;
            Iterator<ServerEntity> it = runningServers.iterator();
            while (it.hasNext()) {
                ServerEntity runningServer = it.next();
                runningServer.currentTaskCost--;
                if (runningServer.currentTaskCost == 0) {
                    it.remove();
                    idleQueue.add(runningServer);
                }
            }
            while (idleQueue.isEmpty()) {
                Iterator<ServerEntity> iterator = runningServers.iterator();
                while (iterator.hasNext()) {
                    ServerEntity runningServer = iterator.next();
                    runningServer.currentTaskCost--;
                    if (runningServer.currentTaskCost == 0) {
                        iterator.remove();
                        idleQueue.add(runningServer);
                    }
                }
                time++;
            }
            for (; taskIndex <= time && taskIndex < tasks.length; taskIndex++) {
                int taskCost = tasks[taskIndex];
                if (!idleQueue.isEmpty()) {
                    ServerEntity serverEntity = idleQueue.poll();
                    ans[taskIndex] = serverEntity.index;
                    serverEntity.currentTaskCost = taskCost;
                    runningServers.add(serverEntity);
                } else {
                    break;
                }
            }
            time++;
        }
        return ans;
    }

    class ServerEntity {
        int index;
        int weight;
        int currentTaskCost;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ServerEntity that = (ServerEntity) o;
            return index == that.index && weight == that.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, weight);
        }

        @Override
        public String toString() {
            return "ServerEntity{" +
                    "index=" + index +
                    ", weight=" + weight +
                    ", currentTaskWeight=" + currentTaskCost +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P3assignTasks().assignTasks(new int[]{3, 3, 2},
                new int[]{1, 2, 3, 2, 1, 2})));
        System.out.println(Arrays.toString(new P3assignTasks().assignTasks(new int[]{5, 1, 4, 3, 2},
                new int[]{2, 1, 2, 4, 5, 2, 1})));
        byte b = 'a';
    }
}
