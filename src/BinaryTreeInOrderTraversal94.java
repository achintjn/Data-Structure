import java.util.*;

public class BinaryTreeInOrderTraversal94 {

    //my solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        if(root==null)
            return list;
        Stack<TreeNode> st = new Stack<>();
        st.add(root);

        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node.right!=null && !set.contains(node))
                st.add(node.right);
            if(!set.contains(node))
                st.add(node);
            if(node.left!=null && !set.contains(node))
                st.add(node.left);
            if(set.contains(node))
                list.add(node.val);
            else
                set.add(node);
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        //st.add(root);
        TreeNode curr = root;

        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.add(curr);
                curr=curr.left;
            }
            curr = st.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
