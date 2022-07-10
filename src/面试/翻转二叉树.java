package 面试;

public class 翻转二叉树 {
    /***
     * 翻转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        solve(root);
        return root;
    }

    private void solve(TreeNode root) {
        if (root == null)
            return;
        TreeNode tem = root.right;
        root.right = root.left;
        root.left = tem;
        solve(root.left);
        solve(root.right);
    }
}
