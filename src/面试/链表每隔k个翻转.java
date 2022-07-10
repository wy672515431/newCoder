package 面试;

public class 链表每隔k个翻转 {
        public ListNode reverseKGroup(ListNode head, int k) {
                ListNode dummy  = new ListNode(-1);
                ListNode prev = dummy;
                ListNode cur = head;
                ListNode tem = head;
                dummy.next = head;
                int length = 0;
                while (tem!=null){
                        length++;
                        tem = tem.next;
                }
                for(int i=0;i<length/k;i++){
                        for(int j=0;j<k-1;j++){
                                tem = cur.next;
                                cur.next = tem.next;
                                tem.next = prev.next;
                                prev.next = tem;
                        }
                        prev = cur;
                        cur = cur.next;
                }
                return dummy.next;
        }
}
