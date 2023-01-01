import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree226 {

    //recursive
    public TreeNode invertTree(TreeNode root) {

        if(root==null)
            return null;


        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left=root.right;
        root.right = temp;

        return root;

    }

    //iterative
    public TreeNode invertTree2(TreeNode root) {
        if(root==null)
            return root;

        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        while(!que.isEmpty()){
            TreeNode curr = que.poll();
            if(curr.left!=null)
                que.add(curr.left);
            if(curr.right!=null)
                que.add(curr.right);
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right=temp;
        }
        return root;

    }
}
