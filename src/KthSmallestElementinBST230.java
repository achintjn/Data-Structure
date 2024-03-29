import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElementinBST230 {

    //DFS or recursive
    int j=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
            return -1;

        if(kthSmallest(root.left,k)!=-1)
            return j;
        j++;
        if(j==k){
            j=root.val;
            return j;
        }
        if(kthSmallest(root.right,k)!=-1)
            return j;

        return -1;

    }

    //BFS or iterative
    public int kthSmallestit(TreeNode root, int k) {

        Stack<TreeNode> st = new Stack<>();
        //st.add(root);
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.add(curr);
                curr = curr.left;
            }

            TreeNode temp = st.pop();
            k--;
            if(k==0)
                return temp.val;
            if(temp.right!=null)
            {
                curr=temp.right;
            }
        }
        return -1;
    }

    //simple inorder soln
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest3(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
}
