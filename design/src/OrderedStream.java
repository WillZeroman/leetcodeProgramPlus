import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    private String[] arr;

    private int ptr;

    public OrderedStream(int n) {
        arr = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey - 1] = value;
        List<String> ans = new ArrayList<>();
        for (int i = ptr; i < arr.length; i++) {
            if (arr[i] == null) {
                break;
            } else {
                ans.add(arr[i]);
            }
        }

        if (idKey - 1 == ptr) {
            while (ptr < arr.length && arr[ptr] != null) {
                ptr++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "ccc"));
        System.out.println(orderedStream.insert(1, "aaa"));
        System.out.println(orderedStream.insert(2, "bbb"));
        System.out.println(orderedStream.insert(5, "eee"));
        System.out.println(orderedStream.insert(4, "ddd"));
    }
}
