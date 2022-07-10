package 面试;

public class 链表倒数第k个节点 {
        /***
         * 获得链表倒数第k个节点
         * 双指针法，我们设立两个节点。让一个指针先向前走k步，另一个指针指向头节点。当快指针到达链表
         * 末尾时，慢指针在链表倒数第K个节点。
         */
        public ListNode getKthFromEnd(ListNode head, int k){
                ListNode fastNode = head;
                ListNode slowNode = head;
                while (k>0 && fastNode!=null){
                        fastNode = fastNode.next;
                        k--;
                }
                while (fastNode!=null){
                        fastNode = fastNode.next;
                        slowNode = slowNode.next;
                }
                return slowNode;
        }
}
