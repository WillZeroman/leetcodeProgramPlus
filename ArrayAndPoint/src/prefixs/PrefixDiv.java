package prefixs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrefixDiv {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>(A.length);
        int tmp = 0;
        for(int i=0;i<A.length;i++){
            tmp = tmp * 2 + A[i];
            res.add(tmp % 5 == 0);
            tmp %= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {0,1,1};
        System.out.println(new PrefixDiv().prefixesDivBy5(a));
        System.out.println(new PrefixDiv().prefixesDivBy5(new int[]{1,1,1}));
        System.out.println(new PrefixDiv().prefixesDivBy5((new int[]{0,1,1,1,1,1})));
        System.out.println(new PrefixDiv().prefixesDivBy5((new int[]{1,1,1,0,1})));
    }
}
