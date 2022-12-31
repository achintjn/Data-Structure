import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree101 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> que = new LinkedList<>();
            Queue<TreeNode> st = new LinkedList<>();
            que.add(root.left);
            st.add(root.right);
            while(!que.isEmpty() && !st.isEmpty()){
                int size = que.size();
                int size2 = st.size();
                if(size!=size2)
                    return false;
                for(int i=0;i<size;i++){
                    TreeNode currL = que.poll();
                    TreeNode currR = st.poll();
                    if(currL==null && currR==null)
                        continue;
                    else if(currL==null || currR==null)
                        return false;
                    else if(currL.val!=currR.val)
                        return false;

                    que.add(currL.left);
                    st.add(currR.right);

                    que.add(currL.right);
                    st.add(currR.left);

                }
            }

            return true;

        }
    }

