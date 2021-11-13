import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator ==0){
            return "0";
        }
        long fenzi = numerator;
        long fenmu = denominator;
        if(fenzi % fenmu == 0){
            long res = fenzi / fenmu;
            return String.valueOf(res);
        }
        StringBuilder res = new StringBuilder();
        if(fenzi<0 ^ fenmu < 0){
            res.append('-');
        }
        fenzi = Math.abs(fenzi);
        fenmu = Math.abs(fenmu);
        long integerPart = fenzi / fenmu;
        res.append(integerPart).append('.');

        StringBuilder fractionPart = new StringBuilder();
        Map<Long,Integer> remainderIndexMap = new HashMap<>();
        long remainder = fenzi % fenmu;
        int index = 0;
        while (remainder!=0 && !remainderIndexMap.containsKey(remainder)){
            remainderIndexMap.put(remainder,index);
            remainder *= 10;
            fractionPart.append(remainder/fenmu);
            remainder %= fenmu;
            index ++;
        }
        if(remainder!=0){
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex,'(');
            fractionPart.append(')');
        }
        res.append(fractionPart.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FractionToDecimal().fractionToDecimal(1,2));
        System.out.println(new FractionToDecimal().fractionToDecimal(1,3));
        System.out.println(new FractionToDecimal().fractionToDecimal(4,333));
        System.out.println(new FractionToDecimal().fractionToDecimal(100,25));
    }
}
