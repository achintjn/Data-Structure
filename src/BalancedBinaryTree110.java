public class BalancedBinaryTree110 {
    boolean isdiff = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isdiff;
    }

    public int height(TreeNode root){
        if(root==null)
            return 0;
        if(!isdiff)
            return 0;
        int left = height(root.left)+1;
        if(!isdiff)
            return 0;
        int right = height(root.right)+1;

        if(Math.abs(left-right)>1)
            isdiff = false;
        return Math.max(left,right);
    }


}
