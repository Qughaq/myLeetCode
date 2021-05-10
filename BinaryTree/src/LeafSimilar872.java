import java.util.ArrayList;
import java.util.List;

public class LeafSimilar872 {
    public boolean leasSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sq1 = new ArrayList<>();
        List<Integer> sq2 = new ArrayList<>();
        if (root1 != null)
            dfs(root1, sq1);
        if (root2 != null)
            dfs(root2, sq2);
        return sq1.equals(sq2);
    }

    private void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null)
            seq.add(node.val);
        else {
            if (node.left != null)
                dfs(node.left, seq);
            if (node.right != null)
                dfs(node.right, seq);
        }
    }
}
