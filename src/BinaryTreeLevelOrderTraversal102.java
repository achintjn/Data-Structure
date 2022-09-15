import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
    //using BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        List<List<Integer>> list2 = new LinkedList<>();
        if(root==null)
            return list2;
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll();
                list.add(curr.val);
                if(curr.left!=null)
                    que.add(curr.left);
                if(curr.right!=null)
                    que.add(curr.right);
            }
            list2.add(list);
        }
        return list2;
    }
}
