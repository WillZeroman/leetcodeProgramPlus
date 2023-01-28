package com;

import java.util.LinkedList;
import java.util.Queue;

public class ReachNumber {
    public int reachNumber(int target) {
        if (target == 0) {
            return 0;
        }
        int ans = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                int right = ans;
                if (num + right == target) {
                    return ans;
                } else {
                    queue.offer(num + right);
                }
                int left = ans * -1;
                if(num + left == target) {
                    return ans;
                } else {
                    queue.offer(num + left);
                }
            }
            ans ++;
        }
        return ans;
    }

    public int best(int target){
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public static void main(String[] args) {
        System.out.println(new ReachNumber().reachNumber(2));
        System.out.println(new ReachNumber().reachNumber(0));
        System.out.println(new ReachNumber().reachNumber(1));
        System.out.println(new ReachNumber().best(-100000));
    }
}
