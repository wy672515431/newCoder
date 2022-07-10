package 面试;

public class 验证二叉搜索树 {
    /**
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树
     * 我们要维护一个左子树的最大值和右子树的最小值
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return  isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper){
        if(root == null)
            return true;
        if(root.val <= lower || root.val >= upper )
            return false;
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    private long pre = Long.MIN_VALUE;
    private boolean inOrder(TreeNode node){
        if(node == null)
            return true;
        boolean l = inOrder(node.left);
        if(node.val <= pre)
            return false;
        pre = node.val;
        boolean r = inOrder(node.right);

        return l && r;
    }

}
