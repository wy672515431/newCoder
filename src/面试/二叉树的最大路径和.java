package 面试;

public class 二叉树的最大路径和 {
        /***
         * 本质上是一个递归问题
         *     a
         *    / \
         *   b   c
         *  对于上面的这个二叉树来说，如果最大路径包括a节点，那么最大路径的值为
         *  1.a+b+C
         *  2 a+b+a的父节点
         *  3 a+c+a的父节点
         * @param root
         * @return
         */
        private int ans = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
                dfs(root);
                return ans;
        }
        public int dfs(TreeNode node){
                if(node == null)
                        return 0;
                //左子节点的最大贡献和
                int left = Math.max(0,dfs(node.left));
                int right = Math.max(0,dfs(node.right));
                ans = Math.max(ans,left+right+node.val);
                return Math.max(0,Math.max(left,right))+node.val;
        }
}
