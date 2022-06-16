 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class MergeTwoBinaryTrees617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null){
            if(root2!=null)
                return root2;
            return root1;
        }

        if(root1.left!=null && root2.left!=null)
            mergeTrees(root1.left,root2.left);
        if(root1.right!=null && root2.right!=null)
            mergeTrees(root1.right,root2.right);
        if(root1.left==null && root2.left!=null)
            root1.left=root2.left;
        if(root1.right==null && root2.right!=null)
            root1.right=root2.right;
        root1.val = root1.val + root2.val;

        return root1;

    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
