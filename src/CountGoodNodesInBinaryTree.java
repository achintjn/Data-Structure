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
}
