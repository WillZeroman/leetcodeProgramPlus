import java.util.HashSet;
import java.util.Set;

public class NumDifferentIntegers {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if((ch>='0' && ch<='9')){
                sb.append(ch);
            }else {
                if(sb.length()>0){
                    int j=0;
                    for(;j<sb.length();j++){
                        if(sb.charAt(j)!='0'){
                            break;
                        }
                    }
                    set.add(sb.substring(j));
                }
                sb = new StringBuilder();
            }
        }
        if(sb.length()>0){
            int j=0;
            for(;j<sb.length();j++){
                if(sb.charAt(j)!='0'){
                    break;
                }
            }
            set.add(sb.substring(j));
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new NumDifferentIntegers().numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(new NumDifferentIntegers().numDifferentIntegers("a1b01c001"));
        System.out.println(new NumDifferentIntegers().numDifferentIntegers("leet1234code234"));
    }
}
