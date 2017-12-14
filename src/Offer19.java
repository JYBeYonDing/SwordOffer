import java.util.ArrayDeque;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 *      8
 *    /  \
 *   6   10
 *  / \  / \
 * 5  7 9 11
 * 镜像二叉树
 *      8
 *    /  \
 *   10   6
 *  / \  / \
 * 11 9 7  5
 */
public class Offer19 {
    public void Mirror(TreeNode root) {
        mirrorRecursively(root);
    }

    private void mirrorRecursively(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorRecursively(root.left);
            mirrorRecursively(root.right);
        }
    }

    private void mirror(TreeNode root) {
        ArrayDeque<TreeNode> treeStack = new ArrayDeque<>();
        TreeNode temp = root;
        if (root != null) {
            treeStack.push(root);
            while (!treeStack.isEmpty()) {
                temp = treeStack.pop();
                if (temp.left != null) {
                    treeStack.push(temp.left);
                }
                if (temp.right != null) {
                    treeStack.push(temp.right);
                }
                TreeNode switTemp = temp.left;
                temp.left = temp.right;
                temp.right = switTemp;
            }
        }
    }
}

