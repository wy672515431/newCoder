package 面试;

public class 二叉搜索树转双循环链表 {
        TreeNode pre;
        TreeNode head;
        public TreeNode treeToDoublyList(TreeNode root) {
                if(root == null)
                        return null;
                convert(root);
                head.left = pre;
                pre.right = head;
                return head;
        }
        public void convert(TreeNode node){
                if(node == null)
                        return;
                if(node.left!=null)
                        convert(node.left);
                node.left = pre;
                if(pre == null)
                        head = node;
                else
                        pre.right = node;
                pre = node;
                if(node.right!=null)
                        convert(node.right);
        }
}
