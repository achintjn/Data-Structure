import java.util.Stack;

public class CountGoodNodesInBinaryTree {
    int count=0;
    public int goodNodes(TreeNode root) {
        goodNodes(root, root.val);
        return count;
    }

    public void goodNodes(TreeNode root, int max){
        if(root==null)
            return;
        if(Math.max(max,root.val)==root.val){
            max=root.val;
            count++;
        }

        goodNodes(root.left,max);
        goodNodes(root.right,max);
    }


    //DFS with stack (iterative)
    class Pair {
        public TreeNode node;
        public int maxSoFar;

        public Pair(TreeNode node, int maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }

    class Solution {
        public int goodNodes(TreeNode root) {
            int numGoodNodes = 0;
            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(root, Integer.MIN_VALUE));

            while (stack.size() > 0) {
                Pair curr = stack.pop();
                if (curr.maxSoFar <= curr.node.val) {
                    numGoodNodes++;
                }

                if (curr.node.left != null) {
                    stack.push(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
                }

                if (curr.node.right != null) {
                    stack.push(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
                }
            }

            return numGoodNodes;
        }
    }
}
