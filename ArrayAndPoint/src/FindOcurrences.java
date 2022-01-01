import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOcurrences {
    public String[] findOcurrences(String text, String first, String second) {
        String[] data = text.split(" ");
        List<String> list = new ArrayList<>();
        for(int i=0;i<data.length-2;i++){
            String tempFirst = data[i];
            String tempSecond = data[i+1];
            if(first.equals(tempFirst) && tempSecond.equals(second)){
                list.add(data[i+2]);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindOcurrences()
                .findOcurrences("alice is a good girl she is a good student","a","good")));
        System.out.println(Arrays.toString(new FindOcurrences()
                .findOcurrences("we will we will rock you","we","will")));
    }
}
