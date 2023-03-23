import java.util.LinkedList;
import java.util.List;

public class PathSumII113 {
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            LinkedList<List<Integer>> res = new LinkedList<>();
            LinkedList<Integer> list = new LinkedList<>();
            backtrack(root,targetSum,list,res);
            return res;
        }

        public void backtrack(TreeNode root, int targetSum, LinkedList<Integer> list, LinkedList<List<Integer>> res){
            if(root==null )
                return;
            //=targetSum = targetSum - root.val;
            list.add(root.val);
            if(targetSum==root.val){
                if(root.left==null && root.right==null){
                    res.add(new LinkedList<>(list));
                    list.removeLast();
                    return;
                }
            }

            targetSum=targetSum-root.val;

            backtrack(root.left,targetSum,list,res);
            backtrack(root.right,targetSum,list,res);
            list.removeLast();
        }
    }
}
