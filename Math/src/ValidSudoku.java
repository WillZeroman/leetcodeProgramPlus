import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            char[] hang = board[i];
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < hang.length; j++) {
                if(hang[j]!='.'){
                    if(!set.add(hang[j])){
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++){
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++){
                if(board[j][i]!='.'){
                    if(!set.add(board[j][i])){
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<>();
            int startI = i / 3 * 3;
            int startJ = (i%3) * 3;
            System.out.println(startI + " | " +startJ);
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k <3; k++) {
                    char ch = board[startI + j][startJ+k];
                    if(ch !='.'){
                        if(!set.add(ch)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
