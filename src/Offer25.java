import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Offer25 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        root.left = left;
        TreeNode right = new TreeNode(12);
        root.right = right;
        left = new TreeNode(4);
        root.left.left = left;
        right = new TreeNode(7);
        root.left.right = right;

        ArrayList<ArrayList<Integer>> paths = FindPath(root, 22);
        for (ArrayList<Integer> path : paths) {
            for (int val : path) {
                System.out.print(val);
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//        if (root == null || target<=0) {
//            return null;
//        }
//        //存放节点路径的栈
//        ArrayDeque<TreeNode> pathStack = new ArrayDeque<>();
//        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
//        ArrayList<Integer> tempPath = new ArrayList<>();
//        int tempValue = 0;
//
//        pathStack.push(root);
//
//
//
//        while (!pathStack.isEmpty()) {
//            TreeNode tempNode = pathStack.peekFirst();
//            if (tempNode.left == null && tempNode.right == null) {
//                //如果是叶子结点
//                tempValue += tempNode.val;
//                if (tempValue == target) {
//                    tempPath.add(tempNode.val);
//                    pathList.add(tempPath);
//                } else {
//                    tempValue -= tempNode.val;
//                }
//                pathStack.pop();
//                tempPath.remove(tempPath.size() - 1);
//            } else {
//                tempPath.add(tempNode.val);
//                if (tempNode.left != null) {
//                    pathStack.push(tempNode.left);
//                }
//                if (tempNode.right != null) {
//                    pathStack.push(tempNode.right);
//                }
//            }
//        }

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        int currentSum = 0;
        findPath(paths, root, target, path, currentSum);
        return paths;
    }

    private static void findPath(ArrayList<ArrayList<Integer>> paths,TreeNode root, int target, ArrayDeque<Integer> path, int currentSum) {
        currentSum += root.val;
        path.addLast(root.val);

        // 如果是叶节点，并且路径上节点之和等于输入的值
        // 打印出这条路径
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == target && isLeaf) {
            ArrayList<Integer> tempPath = new ArrayList<>();
            tempPath.addAll(path);
            paths.add(tempPath);
        }
        //如果不是叶节点，则遍历它的子节点
        if (root.left != null) {
            findPath(paths,root.left,target,path,currentSum);
        }
        if (root.right != null) {
            findPath(paths, root.right, target, path, currentSum);
        }
        //在返回父节点之前，在路径上删除当前节点
        path.removeLast();
    }
}
