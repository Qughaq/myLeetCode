import java.util.*;

public class BinaryTreeSolution {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode parentNode = queue.poll();
                level.add(parentNode.val);
                if (parentNode.left != null)
                    queue.offer(parentNode.left);
                if (parentNode.right != null)
                    queue.offer(parentNode.right);
            }
            result.add(0, level);
        }
        Collections.reverse(result);
        return result;
    }

    /*二叉树的后序遍历*/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private static void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }

    /*二叉树的中序遍历*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    /*二叉树的前序遍历*/
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private static void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}
