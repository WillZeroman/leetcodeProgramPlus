public class CheckRecord {
    public boolean checkRecord(String s) {
        int countA=0;
        int countL=0;
        boolean flagL = false;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'A'){
                countA++;
                countL=0;
            } else if (ch == 'P'){
                countL=0;
            } else {
                countL ++;
            }
            flagL = flagL ? true : countL>=3;
        }
        return countA>=2&&flagL;
    }

    public int checkRecord(int n) {
        return 0;
    }
}
