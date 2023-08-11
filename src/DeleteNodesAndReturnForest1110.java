import java.util.*;

public class DeleteNodesAndReturnForest1110 {
    Set<Integer> set;
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for(int n:to_delete)
            set.add(n);
        res = new LinkedList<>();
        return recursive(root, true);
    }

    public List<TreeNode> recursive(TreeNode root, boolean prevDelete){
        if(prevDelete && !set.contains(root.val))
            res.add(root);

        if(root.left!=null){
            recursive(root.left, set.contains(root.val));
            if(set.contains(root.left.val))
                root.left = null;
        }

        if(root.right!=null){
            recursive(root.right, set.contains(root.val));
            if(set.contains(root.right.val))
                root.right = null;
        }

        return res;
    }


    //iterative
    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        //Set<Integer> set = to_delete.OfStream.mapToObj(x->(Integer)x).collect(toSet());
        Set<Integer> set = new HashSet<>();
        for(int n:to_delete)
            set.add(n);
        Queue<TreeNode> que = new LinkedList<>();
        List<TreeNode> res = new LinkedList<>();
        res.add(root);
        que.add(root);
        while(!que.isEmpty()){
            TreeNode curr = que.poll();
            int val = curr.val;
            if(set.contains(val)){
                res.remove(curr);
            }
            if(curr.left!=null){
                que.add(curr.left);
                if(set.contains(curr.left.val)){
                    curr.left = null;

                }
                if(set.contains(val) && curr.left!=null)
                    res.add(curr.left);
            }
            if(curr.right!=null){
                que.add(curr.right);
                if(set.contains(curr.right.val)){
                    curr.right = null;

                }
                if(set.contains(val) && curr.right!=null)
                    res.add(curr.right);

            }
        }

        return res;
    }
}
