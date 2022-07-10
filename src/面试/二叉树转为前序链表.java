package 面试;

public class 二叉树转为前序链表 {
        private TreeNode last = null;
        public void flatten(TreeNode root) {
                if(root == null)
                        return;
                flatten(root.right);
                flatten(root.left);
                root.right = last;
                root.left = null;
                last = root;
        }
}
