public class InsertIntoAbst701 {
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
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null){
                root = new TreeNode(val);
                return root;
            }
            TreeNode curr = root;

            while(curr!=null){
                if(val>curr.val)
                {
                    if(curr.right==null){
                        curr.right = new TreeNode(val);
                        curr=null;
                    }
                    else
                        curr=curr.right;

                }
                else{
                    if(curr.left==null){
                        curr.left = new TreeNode(val);
                        curr=null;
                    }
                    else
                        curr=curr.left;
                }
            }

            return root;

        }
    }
}
