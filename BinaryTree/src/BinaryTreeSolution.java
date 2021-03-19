import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len > 0) {
            return createMinimalTree(nums, 0, len - 1);
        } else {
            return null;
        }
    }

    private TreeNode createMinimalTree(int[] nums, int left, int right) {
        if (left >= 0 && left <= right && right < nums.length) {
            int mid = left + (right - left) / 2;
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left = createMinimalTree(nums, left, mid - 1);
            treeNode.right = createMinimalTree(nums, mid + 1, right);
            return treeNode;
        } else return null;
    }

    List<Integer> ans = new LinkedList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root.left != null) {
            if (root.right == null) {
                ans.add(root.left.val);
            }
            getLonelyNodes(root.left);
        }
        if (root.right != null) {
            if (root.left == null) {
                ans.add(root.right.val);
            }
            getLonelyNodes(root.right);
        }
        return ans;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode result = new TreeNode(t1.val + t2.val);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);
        return result;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root != null) {
            if (root.val >= low && root.val <= high)
                sum += root.val;
            if (root.val > low)
                sum += rangeSumBST(root.left, low, high);
            if (root.val < high)
                sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return sum == root.val;
        else
            return hasPathSum2(root.left, sum - root.val)
                    || hasPathSum2(root.right, sum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode curNode = nodeStack.pop();
            int curSum = sumStack.pop();
            if (curNode.left == null && curNode.right == null && curSum == 0)
                return true;
            if (curNode.left != null) {
                nodeStack.add(curNode.left);
                sumStack.add(curSum - curNode.left.val);
            }
            if (curNode.right != null) {
                nodeStack.add(curNode.right);
                sumStack.add(curSum - curNode.right.val);
            }
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return right.val == left.val
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    // 查找二叉树的深度
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        if (result.size() > 1)
            for (int i = 0; i < result.size() - 1; i++)
                if (result.get(i) >= result.get(i + 1)) return false;
        return true;
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
