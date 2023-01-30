import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreOrderAndInorder105 {

    //actual solution using divide and conquer
    int index=0;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root = new TreeNode(preorder[0]);
        map = new HashMap<>();
        TreeNode move = root;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return makeTree(preorder,0,preorder.length-1);
    }

    public TreeNode makeTree(int[] preorder, int left, int right){

        if(left>right)
            return null;

        TreeNode root = new TreeNode(preorder[index++]);

        root.left = makeTree(preorder,left,map.get(root.val)-1);
        root.right = makeTree(preorder,map.get(root.val)+1,right);

        return root;
    }


    //my soln, slow but passes all the cases
    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        TreeNode root = new TreeNode(preorder[0]);
        Map<Integer, Integer> map = new HashMap<>();
        TreeNode move = root;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        for(int i=1;i<preorder.length;i++){
            int val = preorder[i];
            boolean loop = true;
            move = root;
            while(loop){
                if(map.get(val)>map.get(move.val)){
                    if(move.right==null){
                        move.right = new TreeNode(val);
                        loop=false;
                    }
                    else
                        move=move.right;
                }
                else{
                    if(move.left==null){
                        move.left = new TreeNode(val);
                        loop=false;
                    }
                    else
                        move=move.left;
                }
            }
        }
        return root;
    }
}
