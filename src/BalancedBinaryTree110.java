public class BalancedBinaryTree110 {
    boolean isdiff = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isdiff;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        if (!isdiff)
            return 0;
        int left = height(root.left) + 1;
        if (!isdiff)
            return 0;
        int right = height(root.right) + 1;

        if (Math.abs(left - right) > 1)
            isdiff = false;
        return Math.max(left, right);
    }

    public boolean isBalanced2(TreeNode root) {

        return isHeight(root) != -1;
    }

    public int isHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = isHeight(root.left);
        int right = isHeight(root.right);

        if (Math.abs(left - right) > 1 || left == -1 || right == -1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
