public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        //int sum = 0;
        return hasPathSum(root.val, root, targetSum);
    }

    public boolean hasPathSum(int sum, TreeNode root, int targetSum){
        if(root.left==null && root.right==null && sum==targetSum)
            return true;
        if(root.left!=null)
            if(hasPathSum(sum+root.left.val, root.left, targetSum))
                return true;
        if(root.right!=null)
            if(hasPathSum(sum+root.right.val, root.right, targetSum))
                return true;
        return false;
    }
}
