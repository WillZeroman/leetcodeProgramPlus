package numEquiv;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NumEquivDominoPairs {
    /**
     * over time
     *
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int sum = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int[] tempI = dominoes[i];
            for (int j = i+1; j < dominoes.length; j++) {
                int[] tempJ = dominoes[j];
                if((tempI[0] == tempJ[0] && tempI[1] == tempJ[1]) || (tempI[0] == tempJ[1] && tempI[1] == tempJ[0])){
                    sum ++;
                }
            }
        }
        return sum;
    }

    public int numEquivDominoPairs_best(int[][] dominoes) {
        Map<PairEntity,Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] tempI = dominoes[i];
            PairEntity entity = new PairEntity(tempI[0],tempI[1]);
            int count = map.getOrDefault(entity,0);
            map.put(entity,count+1);
        }
        int sum = 0;
        for(PairEntity entity:map.keySet()){
            int count = map.get(entity);
            if(count > 1){
                int num = count * (count -1) /2;
                sum += num;
            }
        }
        return sum;
    }

    class PairEntity {
        int min;
        int max;

        PairEntity(int num1,int num2){
            min = Math.min(num1,num2);
            max = Math.max(num1,num2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PairEntity that = (PairEntity) o;
            return min == that.min && max == that.max;
        }

        @Override
        public int hashCode() {
            return Objects.hash(min, max);
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{2,1},{3,4},{4,3},{3,4},{5,6}};
        System.out.println(new NumEquivDominoPairs().numEquivDominoPairs_best(nums));
    }
}
