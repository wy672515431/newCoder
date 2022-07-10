package 面试;

public class 二叉树对称 {
        public boolean isSymmetric(TreeNode root) {
                if(root == null)
                        return true;
                return  solve(root.left,root.right);
        }

        /***
         * 当两节点同时越过叶子节点，为true
         * 不同时或者值不想等，false
         * @param left
         * @param right
         * @return
         */
        public boolean solve(TreeNode left,TreeNode right){
                if(left == null && right == null)
                        return  true;
                if(left == null || right == null || left.val != right.val)
                        return false;
                return solve(left.left,right.right) && solve(left.right,right.left);
        }

        public static void main(String[] args) {
                
        }
}
