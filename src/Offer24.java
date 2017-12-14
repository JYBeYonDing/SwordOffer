/**
 * 二叉搜索树的后序遍历序列
 */
public class Offer24 {
    public static void main(String[] args) {
        int[] tree = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(verifySquenceOfBST(tree));
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
//        if (sequence == null || sequence.length <= 0) {
//            return false;
//        }
//
//        int root = sequence[sequence.length - 1];
//        int i = 0;
//        for(; i<sequence.length-1;i++) {
//            if (sequence[i] > root) {
//                break;
//            }
//        }
//
//        int j = i;
//        for(;j<sequence.length-1;j++) {
//            if (sequence[j] < root) {
//                return false;
//            }
//        }
//
//        boolean leafIsTree = true;
//        int[] left = new int[i];
//        for(int k = 0; k<i;k++) {
//            left[k] = sequence[k];
//        }
//
//        boolean rightIsTree = true;
//        int[] right = new int[sequence.length - i-1];
//        for(int k = 0; k<sequence.length - i-1;k++) {
//            right[k] = sequence[i + k];
//        }
//        if (left.length > 0) {
//            leafIsTree = verifySquenceOfBST(left);
//        }
//        if (right.length > 0) {
//            rightIsTree = verifySquenceOfBST(right);
//        }
//        return leafIsTree && rightIsTree;


        /**
         * 非递归版，没看懂
         */
        int size = sequence.length;
        if(0==size)return false;

        int i = 0;
        while(--size>0)
        {
            while(sequence[i++]<sequence[size]);
            while(sequence[i++]>sequence[size]);

            if(i<size)return false;
            i=0;
        }
        return true;
    }
}
