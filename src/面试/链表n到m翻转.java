package 面试;



public class 链表n到m翻转 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
                //头插法的应用
                ListNode dummy = new ListNode(-1,head);
                ListNode prev = dummy;
                for(int i=1;i<left;i++)
                        prev = prev.next;
                ListNode cur = prev.next;
                for(int i=left;i<right;i++){
                        ListNode tem = cur.next;
                        cur.next = tem.next;
                        tem.next = prev.next;
                        prev.next = tem;
                }
                return dummy.next;
        }

        /**
         *
         * @param head 要反转链表的头节点
         * @return
         */
        public ListNode reverseList(ListNode head){
                ListNode dummy = new ListNode(-1);
                dummy.next = head;
                if(head == null || head.next == null)
                        return head;
                ListNode prev = head;
                ListNode cur = head.next;
                while(cur!=null){
                        ListNode tem = cur.next;
                        cur.next = prev;
                        prev = cur;
                        cur = tem;
                }
                dummy.next.next = null;
                dummy.next = prev;
                return  dummy.next;

        }
}
