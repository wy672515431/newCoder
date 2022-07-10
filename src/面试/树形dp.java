package 面试;

import java.util.*;

public class 树形dp {
    /***
     * 一个点被选中，那么它的父子数不能被选中.
     * 则一个节点有两个状态,未选中和选中
     * 主要思考父节点和子节点的关系
     * @param root
     * @return
     */
    private HashMap<TreeNode, Integer> maxNotSelected = new HashMap<>();
    private HashMap<TreeNode, Integer> maxSelected = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(maxNotSelected.getOrDefault(root, 0), maxSelected.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        dfs(root.right);
        //未选中时，其的子节点可以选也可以不选
        maxNotSelected.put(root, Math.max(maxNotSelected.getOrDefault(root.left, 0), maxSelected.getOrDefault(root.left, 0))
                + Math.max(maxNotSelected.getOrDefault(root.right, 0), maxSelected.getOrDefault(root.right, 0)));
        maxSelected.put(root, maxNotSelected.getOrDefault(root.left, 0) + maxNotSelected.getOrDefault(root.right, 0) + root.val);
    }
}
