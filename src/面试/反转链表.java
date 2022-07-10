package 面试;
public class 反转链表 {
        /***
         * 迭代法
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head){
                ListNode prev = null;
                ListNode cur = head;
                while (cur!=null){
                        ListNode tem = cur.next;
                        cur.next = prev;
                        prev = cur;
                        cur  = tem;
                }
                return prev;
        }

        /***
         * 递归法
         */
        public ListNode reverseList1(ListNode head){
                if(head == null || head.next == null)
                        return head;
                ListNode node = reverseList(head.next);
                head.next.next = head;
                head.next = null;
                return  node;
        }

}
