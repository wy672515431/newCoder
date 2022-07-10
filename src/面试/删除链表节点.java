package 面试;

public class 删除链表节点 {
        /***
         * 使每个元素都只出现一次
         */
        public ListNode deleteDuplicates(ListNode head){
                if(head == null || head.next == null)
                        return head;
                ListNode prev = head;
                ListNode cur = head.next;
                while (cur!=null){
                        if(prev.val == cur.val){
                                prev.next = cur.next;
                                cur = cur.next;
                        }else{
                                prev = cur;
                                cur  = cur.next;
                        }
                }
                return head;
        }
        /***
         * 将重复的元素完全删除
         */
        public ListNode deleteDuplicates1(ListNode head){
                if(head == null)
                        return null;
                ListNode dummy = new ListNode(0,head);
                ListNode cur = dummy;
                while (cur.next != null && cur.next.next != null){
                        if(cur.next.val == cur.next.next.val){
                                int x = cur.next.val;
                                while(cur.next.val == x){
                                        cur.next = cur.next.next;
                                }
                        }else{
                                cur = cur.next;
                        }
                }
                return dummy.next;
        }
}
