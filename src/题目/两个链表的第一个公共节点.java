package 题目;

public class 两个链表的第一个公共节点 {
        /***
         * 我们通过两个指针指向两个链表的头节点，当h1到达headA末尾后,将其指向headB。当h2到达headB后
         * 将其指向headA。若二者没有公共点，最后一定会同时指向Null,如果二者有公共点，最后一定在公共点
         * 相遇。
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

                ListNode h1 = headA, h2 = headB;
                while (h1 != h2) {

                        h1 = h1 == null ? headB : h1.next;
                        h2 = h2 == null ? headA : h2.next;
                }

                return h1;
        }
}
