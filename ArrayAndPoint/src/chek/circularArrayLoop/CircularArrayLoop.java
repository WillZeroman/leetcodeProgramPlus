package chek.circularArrayLoop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        if(nums.length == 1){
            return false;
        }
        Set<Integer> visitedIndex = new HashSet<>();
        for(int i=0;i<nums.length;i++){
           if(!visitedIndex.contains(i)){
               Set<Integer> tempVisited = new HashSet<>();
               int nextIndex = i;
               boolean primary = nums[i]>0;
               while (!tempVisited.contains(nextIndex)&&nums[nextIndex]>0==primary){
                   tempVisited.add(nextIndex);
                   nextIndex = next(nums,nextIndex);
               }
               if(nums[nextIndex]>0==primary){
                   int count =0;
                   int flagIndex =nextIndex;
                   do{
                        count ++;
                       nextIndex = next(nums,nextIndex);
                   } while (nextIndex !=flagIndex);
                   if(count > 1){
                       return true;
                   }
               }
               visitedIndex.addAll(tempVisited);
           }
        }
        return false;
    }

    private int next(int[] nums,int index){
        int nextIndex = index + nums[index];
        while (nextIndex<0){
            nextIndex += nums.length;
        }
        return nextIndex%nums.length;
    }

    public static void main(String[] args) {
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{2,-1,1,-2,-2}));
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{2,-1,1,2,2}));
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{-1,2}));
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{1,1,2}));
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{-2,-3,-9}));
    }
}
