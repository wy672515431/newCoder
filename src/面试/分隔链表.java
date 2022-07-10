package 面试;

public class 分隔链表 {
        public ListNode partition(ListNode head, int x) {
                ListNode dummy = new ListNode(-1);
                ListNode dummy1 = new ListNode(-1);
                ListNode cur = dummy;
                ListNode cur1 = dummy1;
                while(head!=null){
                        if(head.val<x){
                                cur.next = head;
                                cur = cur.next;
                        }else{
                                cur1.next = head;
                                cur1 = cur1.next;
                        }
                        head = head.next;
                }
                cur.next = dummy1.next;
                cur1.next = null;
                return dummy.next;
        }

        public static void main(String[] args) {

        }
}
