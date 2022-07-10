package 面试;

public class 把二叉搜索树转为累加树 {
        /***
         * 我们发现对于三个节点的二叉搜索树，右节点的值不变，根节点的值由右节点的值决定，左节点由根节点和右节点确定
         * 故可以反着中序遍历
         */
        private int sum = 0;
        public TreeNode bstToGst(TreeNode root) {
                if(root!=null){
                        bstToGst(root.right);
                        sum+=root.val;
                        root.val = sum;
                        bstToGst(root.left);
                }
                return root;
        }
}
