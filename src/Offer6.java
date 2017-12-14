/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


public class Offer6 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) throws Exception {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }

        return createTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    private static TreeNode createTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) throws Exception {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = null;
        root.right = null;

        if (preStart == preEnd) {
            if (inStart == inEnd) {
                return root;
            } else {
                throw new Exception("无法构成二叉树");
            }
        }

        //在中序遍历中确定左右子树的长度
        for(int i = inStart ; i<=inEnd ; i++) {
            if (in[i] == root.val) {
                root.left = createTree(pre, preStart + 1, i - inStart + preStart, in, inStart, i - 1);
                root.right = createTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
            }
        }

        return root;
    }

    public static void main(String[] args) throws Exception {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        reConstructBinaryTree(pre, in);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}