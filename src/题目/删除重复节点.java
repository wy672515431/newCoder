package 题目;

public class 删除重复节点 {
        public ListNode deleteDuplicates(ListNode head) {
                if(head == null || head.next == null)
                        return head;
                boolean flag = false;
                ListNode dummy = new ListNode(Integer.MAX_VALUE);
                dummy.next = head;
                ListNode prev = dummy;
                ListNode prev1 = head;
                ListNode cur = head.next;
                while(cur!=null){
                        if(prev1.val == cur.val){
                                flag = true;
                                deleteNode(prev1,cur);
                                cur = prev1.next;
                        }else{
                                if(flag){
                                        deleteNode(prev,prev1);
                                        prev1 = prev.next;
                                        cur = cur.next;
                                        flag = false;
                                }else{
                                        prev = prev1;
                                        prev1 = cur;
                                        cur = cur.next;
                                }
                        }
                }
                if(flag){
                        deleteNode(prev,prev1);
                        prev1 = prev.next;
                }
                return dummy.next;

        }
        public void deleteNode(ListNode prev,ListNode cur){
                prev.next = cur.next;
                cur.next = null;
                //cur指向下一个节点
        }

        public static void main(String[] args) {
                ListNode head = new ListNode(2);
                ListNode node = new ListNode(2);
                head.next = node;
                new 删除重复节点().deleteDuplicates(head);
        }
}
