package 面试;

public class 重排链表 {
        public void reorderList(ListNode head) {
                if(head == null || head.next == null)
                        return ;
                ListNode slowNode = head;
                ListNode fastNode = head;
                while(fastNode!=null && fastNode.next != null){
                        fastNode = fastNode.next.next;
                        slowNode = slowNode.next;
                }
                ListNode head1 = reverseList(slowNode.next);
                slowNode.next = null;
                ListNode cur = head;
                while(cur!=null && head1!=null){
                        ListNode tem = cur.next;
                        ListNode tem1 = head1.next;

                        cur.next = head1;
                        head1.next = tem;
                        cur = tem;
                        head1 = tem1;
                }

        }
        public ListNode reverseList(ListNode head){
                ListNode prev = null;
                ListNode cur = head;
                while(cur!=null){
                        ListNode tem = cur.next;
                        cur.next = prev;
                        prev = cur;
                        cur = tem;
                }
                return prev;
        }
}
