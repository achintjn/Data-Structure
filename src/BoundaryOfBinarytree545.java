import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinarytree545 {
    List<Integer> list  = new ArrayList<>();
    Stack<Integer> stc = new Stack<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        list.add(root.val);
        goLeft(root.left);
        addLeaves(root.left);
        addLeaves(root.right);
        goRight(root.right);
        while(!stc.isEmpty())
            list.add(stc.pop());

        return list;
    }
    public void goLeft(TreeNode root){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        list.add(root.val);
        if(root.left!=null)
            goLeft(root.left);
        else if(root.right!=null)
            goLeft(root.right);
    }
    public void addLeaves(TreeNode root){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            list.add(root.val);
        addLeaves(root.left);
        addLeaves(root.right);
    }

    public void goRight(TreeNode root){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        stc.add(root.val);
        if(root.right!=null)
            goRight(root.right);
        else if(root.left!=null)
            goRight(root.left);
    }
}
