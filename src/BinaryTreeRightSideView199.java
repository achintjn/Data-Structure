import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {

    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll();
                if(curr.left!=null)
                    que.add(curr.left);
                if(curr.right!=null)
                    que.add(curr.right);
                if(i==size-1)
                    list.add(curr.val);
            }
        }
        return list;
    }

    //DFS
    List<Integer> list = new LinkedList<>();
    public List<Integer> rightSideViewDFS(TreeNode root) {
        if(root==null)
            return list;
        dfs(root,0);
        return list;
    }

    public void dfs(TreeNode root, int i){
        if(i==list.size())
            list.add(root.val);

        if(root.right!=null)
            dfs(root.right,i+1);
        if(root.left!=null)
            dfs(root.left,i+1);
        return;
    }
}
