public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int max = releaseTimes[0];
        for (int i=1;i<keysPressed.length();i++) {
            char ch = keysPressed.charAt(i);
            int time = releaseTimes[i] - releaseTimes[i-1];
            if(time > max || (time == max && ans-'a' < ch-'a')) {
                ans = ch;
                max = time;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //[12,23,36,46,62]
        //"spuda"
        System.out.println(new SlowestKey().slowestKey(new int[]{12,23,36,46,62},"spuda"));
    }
}
