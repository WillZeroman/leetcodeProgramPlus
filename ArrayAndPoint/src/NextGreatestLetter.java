public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters.length == 1) {
            return letters[0];
        }
        char first = letters[0];
        if (target < first) {
            return first;
        }
        char last = letters[letters.length - 1];
        if (last <= target) {
            return first;
        }
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left];
    }

    public static void main(String[] args) {
        System.out.println(new NextGreatestLetter().nextGreatestLetter(new char[]{'c','f','j'},'c'));
        System.out.println(new NextGreatestLetter().nextGreatestLetter(new char[]{'c','f','j'},'f'));
        System.out.println(new NextGreatestLetter().nextGreatestLetter(new char[]{'c','f','j'},'j'));
        System.out.println(new NextGreatestLetter().nextGreatestLetter(new char[]{'c','f','j'},'g'));
    }
}
