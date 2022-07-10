package 面试;

public class 奇偶链表 {
        public ListNode oddEvenList(ListNode head) {
                if(head == null || head.next == null)
                        return head;
                ListNode head1 = head.next;
                ListNode cur = head;
                ListNode cur1 = head.next;
                while(cur1!=null && cur1.next!=null){
                        cur.next = cur1.next;
                        cur = cur1.next;
                        cur1.next = cur.next;
                        cur1 = cur.next;
                }
                cur.next = head1;
                return head;
        }
}
