package 面试;

public class 单链表构造二叉搜索树 {
        public TreeNode sortedListToBST(ListNode head) {
                //链表的中间节点为根节点
                //左边为左子树
                //右边为右子树
                if(head == null)
                        return null;
                if(head.next == null)
                        return new TreeNode(head.val);
                ListNode pre = head;
                ListNode sp = head.next;
                ListNode fp = sp.next;
                while(fp!=null && fp.next!=null){
                        pre = pre.next;
                        sp = sp.next;
                        fp = fp.next.next;
                }
                pre.next = null;
                TreeNode root = new TreeNode(sp.val);
                root.left = sortedListToBST(head);
                root.right = sortedListToBST(sp.next);
                return root;
        }
}
