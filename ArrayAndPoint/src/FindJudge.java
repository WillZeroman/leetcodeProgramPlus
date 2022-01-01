public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        if(n==1) {
            return 1;
        }
        Point[] points = new Point[n+1];
        for(int[] trustData:trust) {
            Point first = points[trustData[0]];
            if(first == null){
                first = new Point();
                first.index = trustData[0];
                first.outCount++;
                points[first.index] = first;
            } else {
                first.outCount ++;
            }
            Point second = points[trustData[1]];
            if(second == null){
                second = new Point();
                second.index = trustData[1];
                second.inCount++;
                points[second.index] = second;
            } else {
                second.inCount ++;
            }
        }
        for(int i=1;i<=n;i++){
            Point point = points[i];
            if(point!=null){
                if(point.inCount==n-1&&point.outCount==0){
                    return point.index;
                }
            }
        }
        return -1;
    }
    class Point {
        int index;
        int inCount;
        int outCount;
    }

    public static void main(String[] args) {
        System.out.println(new FindJudge().findJudge(2,new int[][]{{1,2}}));
        System.out.println(new FindJudge().findJudge(3,new int[][]{{1,3},{2,3}}));
        System.out.println(new FindJudge().findJudge(3,new int[][]{{1,3},{2,3},{3,1}}));
    }
}
