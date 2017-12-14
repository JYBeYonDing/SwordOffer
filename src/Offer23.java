import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Offer23 {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        ArrayList<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode temp = treeNodes.pollFirst();
            values.add(temp.val);
            if (temp.left != null) {
                treeNodes.add(temp.left);
            }
            if (temp.right != null) {
                treeNodes.add(temp.right);
            }
        }

        return values;
    }
}
