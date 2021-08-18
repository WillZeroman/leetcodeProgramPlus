public class MinimumPerimeter {

    /**
     * f(x) = f(x-2) + 4 * sum(x/2,x)
     * f(2) = 0 + 4 * (1 + 2)
     *
     * @param neededApples
     * @return
     */
    public long minimumPerimeter(long neededApples) {
        long sum = 12;
        long bian = 2;
        while (sum<neededApples){
            bian +=2;
            long tempSumX = (bian * (bian +1))/2 - ((bian/2 -1)*(bian/2)/2);
            long tempSumY = tempSumX - bian/2-bian;

//            for(long i=bian/2;i<=bian;i++){
//                tempSumX +=i;
//                if(i!=bian/2 && i!=bian){
//                    tempSumY +=i;
//                }
//            }
            sum += (4 * (tempSumX + tempSumY));
        }
        return bian * 4;
    }

    public static void main(String[] args) {
        //System.out.println(new MinimumPerimeter().minimumPerimeter(1));
        System.out.println(new MinimumPerimeter().minimumPerimeter(13));
        System.out.println(new MinimumPerimeter().minimumPerimeter(1000000000));
        System.out.println(new MinimumPerimeter().minimumPerimeter(350551360251708L));
    }
}
