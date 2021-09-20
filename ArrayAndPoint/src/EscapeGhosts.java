public class EscapeGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = distance(new int[]{0,0},target);
        for(int[] ghost:ghosts){
            if(distance(ghost,target)<=dist){
                return false;
            }
        }
        return true;
    }

    private int distance(int[] source, int[] target){
        return Math.abs(source[0]-target[0])+Math.abs(source[1]-target[1]);
    }

    public static void main(String[] args) {
        int[][] ghosts= {{1,0},{0,3}};
        System.out.println(new EscapeGhosts().escapeGhosts(ghosts,new int[]{0,1}));
    }
}
