import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree104 {
    //DFS
    public int maxDepth(TreeNode root) {
        int depth=0;
        return maxDepth(root,depth);
    }

    public int maxDepth(TreeNode root, int depth){
        if(root==null)
            return depth;

        depth++;
        depth = Math.max(maxDepth(root.left, depth),maxDepth(root.right, depth));

        return depth;
    }

    //BFS
    public int maxDepth2(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int depth=0;
        while(!que.isEmpty()){
            int size =  que.size();
            depth++;
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll();
                if(curr.right!=null)
                    que.add(curr.right);
                if(curr.left!=null)
                    que.add(curr.left);
            }
        }
        return depth;
    }
}
