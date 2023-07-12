import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPostOrder106 {
    int idx;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        idx = inorder.length;
        return buildTree(0,inorder.length-1,postorder);
    }
    public TreeNode buildTree(int left, int right, int[] p){
        if(left>right)
            return null;
        idx--;
        int val = p[idx];
        TreeNode node = new TreeNode(val);

        node.right  = buildTree(map.get(val)+1,right,p);
        node.left  = buildTree(left,map.get(val)-1,p);

        return node;
    }
}
