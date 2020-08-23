public class P2minOperation {
    public int minOperations(int n) {
        int count = 0;
        int cursor = 1;
        while (cursor < n) {
            count += (n - cursor);
            cursor += 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P2minOperation().minOperations(3));
        System.out.println(new P2minOperation().minOperations(6));
        System.out.println(new P2minOperation().minOperations(1));
        System.out.println(new P2minOperation().minOperations(5));
    }
}
