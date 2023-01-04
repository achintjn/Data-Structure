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

    //using inorder traversal
    //every element should be less then next one
    Integer val = null;
    public boolean isValidBST2(TreeNode root) {

        return isValid(root);
    }

    public boolean isValid(TreeNode root){
        if(root==null)
            return true;
        if(!isValid(root.left))
            return false;
        if(val!=null && val>=root.val)
            return false;
        val = root.val;
        if(!isValid(root.right))
            return false;

        return true;
    }
}
