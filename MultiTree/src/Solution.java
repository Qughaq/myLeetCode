import java.util.List;

class Solution {
    List<Integer> result;

    public List<Integer> postorder(Node root) {
        if (root == null) return null;
        for (Node children : root.children) {
            postorder(children);
        }
        result.add(root.val);
        return result;
    }
}