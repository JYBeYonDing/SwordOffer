/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Offer39_2 {
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right)>1) {
            isBalanced = false;
        }

        return right > left ? right+1 : left+1;
    }
}
