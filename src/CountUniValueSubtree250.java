public class CountUniValueSubtree250 {
    int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null){
            return count;
        }
        if(root.left==null && root.right==null){
            count++;
            return count;
        }

        countUnivalSubtrees(root.left);
        countUnivalSubtrees(root.right);
        if((root.left==null || root.val==root.left.val) && (root.right==null || root.val==root.right.val)){
            count++;
        }
        else
            root.val=1001;

        return count;
    }
}
