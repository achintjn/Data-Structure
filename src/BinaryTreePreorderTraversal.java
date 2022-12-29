import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {


        Stack<TreeNode> que = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        que.add(root);

        while(!que.isEmpty()){
            TreeNode node = que.pop();
            list.add(node.val);
            if(node.right!=null)
                que.add(node.right);
            if(node.left!=null)
                que.add(node.left);
        }
        return list;
    }
}
