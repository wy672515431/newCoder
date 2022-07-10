package 面试;

import java.security.PublicKey;
import java.util.List;

public class 回文链表 {
        /***
         * 判断链表是否是回文的。
         * 时间复杂度O(N),空间复杂度O(N)
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head){
                int length = 0;
                ListNode cur = head;
                while (cur!=null){
                        length++;
                        cur = cur.next;
                }
                int[] a = new int[length];
                int cnt = 0;
                cur = head;
                while (cur!=null){
                        a[cnt++] = cur.val;
                        cur = cur.next;
                }
                int i = 0;
                int j = length-1;
                while (i<j){
                        if(a[i] != a[j])
                                return false;
                        i++;
                        j--;
                }
                return  true;
        }

        /***
         * 时间复杂度O(n),空间复杂度O(1);
         * @param head
         * @return
         */
        public boolean isPalindrome1(ListNode head){
                if(head == null)
                        return true;
                ListNode half = findHalfNode(head);
                ListNode half1 = reverseList(half.next);
                half.next = null;
                while (half1!=null){
                        if(head.val != half1.val)
                                return  false;
                        else{
                                head = head.next;
                                half1 = half1.next;
                        }
                }
                return true;
        }
        public ListNode findHalfNode(ListNode head){
                ListNode slowNode = head;
                ListNode fastNode = head;
                while (fastNode.next!=null && fastNode.next.next!=null){
                        fastNode = fastNode.next.next;
                        slowNode = slowNode.next;
                }
                return slowNode;
        }
        public ListNode reverseList(ListNode head){
                ListNode dummy  = new ListNode(0);
                dummy.next = head;
                ListNode prev = dummy;
                ListNode cur = head;
                while (cur.next!=null){
                        ListNode next = cur.next;
                        cur.next = next.next;
                        next.next = prev.next;
                        prev.next = next;
                }
                return  dummy.next;
        }
}
