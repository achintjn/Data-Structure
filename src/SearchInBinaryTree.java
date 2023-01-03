public class SearchInBinaryTree {

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

        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode curr = root;
            while(curr!=null){
                if(val>curr.val)
                    curr=curr.right;
                else if(val<curr.val)
                    curr=curr.left;
                else if(curr.val==val)
                    return curr;
            }
            return null;

        }

        //recursive
    public TreeNode searchBST2(TreeNode root, int val) {
        if(root==null)
            return null;

        if(val==root.val)
            return root;

        if(val<root.val)
            return searchBST(root.left,val);
        else
            return searchBST(root.right,val);

    }

}
