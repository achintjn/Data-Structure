public class ValidateBST98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null, null) ;
    }

    public boolean isValidBST(TreeNode root, Integer gt, Integer lt){
        if(root==null)
            return true;
        if((lt!=null && root.val>=lt) || (gt!=null && root.val<=gt))
            return false;
        return isValidBST(root.left,gt,root.val) && isValidBST(root.right,root.val,lt);
    }
}
