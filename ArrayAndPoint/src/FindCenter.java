public class FindCenter {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] arr = new int[n + 1];
        for(int[] edge : edges) {
            arr[edge[0]] +=1;
            arr[edge[1]] +=1;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]==n-1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindCenter().findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}}));
    }
}
