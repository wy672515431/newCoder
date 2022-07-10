package 面试;

public class 二叉树的直径 {
        private int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
                getDepth(root);
                return ans-1;
        }
        public int getDepth(TreeNode root){
                if(root == null)
                        return 0;
                int lmax = getDepth(root.left);
                int rmax = getDepth(root.right);
                ans = Math.max(lmax+rmax+1,ans);
                return Math.max(lmax,rmax)+1;
        }
}
