public class FlattenBinaryTreeToLinkedList114 {
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

        public void flatten(TreeNode root) {
            flatten2(root);
        }

        public TreeNode flatten2(TreeNode root){
            if(root == null)
                return null;

            if(root.left==null && root.right==null)
                return root;

            TreeNode leftNode = flatten2(root.left);
            TreeNode rightNode = flatten2(root.right);

            if(leftNode!=null){
                leftNode.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            return (rightNode!=null)?rightNode:leftNode;
        }
}
