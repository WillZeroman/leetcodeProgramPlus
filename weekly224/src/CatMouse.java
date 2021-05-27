import java.util.Arrays;

public class CatMouse {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        char[][] graph = new char[grid.length][grid[0].length()];
        for(int i=0;i<grid.length;i++){
            graph[i] = grid[i].toCharArray();
        }
        //display(graph);


        return true;
    }

    public void display(char[][] graph){
        for(int i=0;i<graph.length;i++){
            System.out.println(Arrays.toString(graph[i]));
        }
    }

    public static void main(String[] args) {

    }
}
