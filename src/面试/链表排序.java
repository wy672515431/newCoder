package 面试;

public class 链表排序 {
        public ListNode sortList(ListNode head) {
                return merge(head);
        }
        public ListNode merge(ListNode head){
                if(head == null || head.next == null)
                        return head;
                ListNode slow = head;
                ListNode fast = head.next;
                while(fast!=null && fast.next!=null){
                        slow = slow.next;
                        fast = fast.next.next;
                }
                ListNode head1 = slow.next;
                slow.next = null;
                return mergeTwoLists(merge(head),merge(head1));
        }
        public ListNode mergeTwoLists(ListNode l1,ListNode l2){
                if(l1 == null)
                        return l2;
                if(l2 == null)
                        return l1;
                ListNode dummy =  new ListNode(-1);
                ListNode cur = dummy;
                ListNode tem1 = l1;
                ListNode tem2 = l2;
                while(tem1!=null&&tem2!=null){
                        if(tem1.val<tem2.val){
                                cur.next = tem1;
                                tem1 = tem1.next;
                        }else{
                                cur.next = tem2;
                                tem2 = tem2.next;
                        }
                        cur = cur.next;
                }
                if(tem1!=null)
                        cur.next = tem1;
                if(tem2!=null)
                        cur.next = tem2;
                return dummy.next;
        }
}
