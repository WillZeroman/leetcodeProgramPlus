import com.sun.source.tree.WhileLoopTree;

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0 || postorder.length == 1) {
            return true;
        }

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] data, int i, int j) {
        if (i < j) {
            int cur = i;
            while (data[cur]<data[j]){
                cur++;
            }
            int mid = cur;
            while (data[cur]>data[j]){
                cur++;
            }
            return cur == j && verifyPostorder(data,i,mid-1) && verifyPostorder(data,mid,j-1);
        }
        return true;
    }

    private int partition(int[] postorder, int i, int j) {
        int flag = postorder[j];
        while (postorder[j] >= flag && i < j) {
            j--;
        }
        while (postorder[i] <= flag && i < j) {
            i++;
        }
        if (i == j) {
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new VerifyPostorder().verifyPostorder(new int[]{1,3,2,6,5}));
//        System.out.println(new VerifyPostorder().verifyPostorder(new int[]{1,6,3,2,5}));
        System.out.println(new VerifyPostorder().verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
    }
}
