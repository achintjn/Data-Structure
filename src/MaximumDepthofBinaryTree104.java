public class MaximumDepthofBinaryTree104 {
    public int maxDepth(TreeNode root) {
        int depth=0;
        return maxDepth(root,depth);
    }

    public int maxDepth(TreeNode root, int depth){
        if(root==null)
            return depth;

        depth++;
        depth = Math.max(maxDepth(root.left, depth),maxDepth(root.right, depth));

        return depth;
    }
}
