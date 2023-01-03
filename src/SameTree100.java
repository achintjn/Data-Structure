import java.util.LinkedList;
import java.util.Queue;

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        Queue<TreeNode> quep = new LinkedList<>();
        Queue<TreeNode> queq = new LinkedList<>();
        if((p==null || q==null) || (p.val!=q.val))
            return false;

        quep.add(p);
        queq.add(q);


        while(!quep.isEmpty() && !queq.isEmpty()){
            if(quep.size()!=queq.size())
                return false;
            int size = quep.size();

            for(int i=0;i<size;i++){
                TreeNode currp = quep.poll();
                TreeNode currq = queq.poll();
                if(currp.left!=null && currq.left!=null){
                    if(currp.left.val==currq.left.val){
                        quep.add(currp.left);
                        queq.add(currq.left);
                    }
                    else
                        return false;
                }
                else if(currp.left!=null || currq.left!=null)
                    return false;

                if(currp.right!=null && currq.right!=null){
                    if(currp.right.val==currq.right.val){
                        quep.add(currp.right);
                        queq.add(currq.right);
                    }
                    else
                        return false;
                }
                else if(currp.right!=null || currq.right!=null)
                    return false;
            }

        }
        return true;

    }

    public boolean isSameTreerecur(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.val!=q.val)
            return false;

        return (isSameTree(p.left,q.left) && isSameTree(p.right, q.right));

    }
}
