import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree111 {
    //DFS
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;


        if(root.right==null)
            return minDepth(root.left) +1;
        if(root.left==null)
            return minDepth(root.right) +1;

        return Math.min(minDepth(root.right),minDepth(root.left)) +1;
    }

    //BFS
    public int minDepthBFS(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int depth = 0;
        while(!que.isEmpty()){
            int size = que.size();
            depth++;
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll();
                if(curr.left==null && curr.right==null)
                    return depth;
                if(curr.left!=null)
                    que.add(curr.left);
                if(curr.right!=null)
                    que.add(curr.right);
            }
        }
        return 0;
    }
}
