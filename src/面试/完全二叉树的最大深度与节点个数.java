package 面试;

public class 完全二叉树的最大深度与节点个数 {
        /***
         * 我们先找到完全二叉树的最左节点，即左子树的深度。
         * 然后找到右子树的最左节点，即右子树的深度
         * 如果左子树的深度 == 右子树的深度
         * 说明左子树为满二叉树 左子树节点个数为2^lepth-1，加上根节点，则为2^lepth。
         * 我们在递归遍历右子树即可。
         * 如果左子树的深度>右子树的深度
         * 则说明右子树为满二叉树。
         * @param root
         * @return
         */
        public int countNodes(TreeNode root) {
                if(root == null)
                        return 0;
                int leftDepth = 0;
                TreeNode cur = root.left;
                while (cur!=null){
                        leftDepth++;
                        cur = cur.left;
                }
                int rightDepth = 0;
                cur = root.right;
                while (cur!=null){
                        rightDepth++;
                        cur = cur.left;
                }
                if(leftDepth == rightDepth){
                        return (int)Math.pow(2,leftDepth)+countNodes(root.right);
                }else{
                        return (int)Math.pow(2,rightDepth)+countNodes(root.left);
                }
        }
}
