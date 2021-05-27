package str;

public class KmpStr {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new KmpStr().strStr("test","st"));
    }
}
