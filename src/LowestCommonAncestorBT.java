public class LowestCommonAncestorBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root.val==p.val || root.val==q.val)
            return root;

        TreeNode one = lowestCommonAncestor(root.left,p,q);
        TreeNode two = lowestCommonAncestor(root.right,p,q);

        if(one==null)
            return two;
        if(two==null)
            return one;
        return root;
    }
}
