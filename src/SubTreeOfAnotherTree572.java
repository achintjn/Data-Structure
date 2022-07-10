public class SubTreeOfAnotherTree572 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root==null)
                return false;

            if(checkSub(root, subRoot))
                return true;

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public boolean checkSub(TreeNode root, TreeNode subRoot){
            if(root==null && subRoot==null)
                return true;
            else if( root==null || subRoot==null || root.val!=subRoot.val){
                return false;
            }
            else
                return (checkSub(root.left,subRoot.left) && checkSub(root.right,subRoot.right));




        }

}
