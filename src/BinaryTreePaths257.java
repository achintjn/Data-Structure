import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths257 {
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
        List<String> list = new LinkedList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            binaryPath(root,"");
            return list;
        }

        public void binaryPath(TreeNode root, String s){
            if(root==null)
                return;
            s = s + Integer.toString(root.val);
            if(root.left==null && root.right==null)
            {
                list.add(s);
                return;
            }
            s = s+"->";
            binaryPath(root.left,s);
            binaryPath(root.right,s);
        }
    }
}
