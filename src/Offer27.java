/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Offer27 {
    private TreeNode lastNode = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }


        convertToDeque(pRootOfTree);

        while (lastNode.left != null) {
            lastNode = lastNode.left;
        }

        return lastNode;
    }

    private void convertToDeque(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        if (currentNode.left != null) {
            convertToDeque(currentNode.left);
        }

        currentNode.left = lastNode;

        if (lastNode != null) {
            lastNode.right = currentNode;
        }

        lastNode = currentNode;

        if (currentNode.right != null) {
            convertToDeque(currentNode.right);
        }


    }
}
