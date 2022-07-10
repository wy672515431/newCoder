package 题目;

import java.util.ArrayList;
import java.util.List;

public class 快慢指针 {
    /***
     * 链表里面的快慢指针
     * 应用：判断链表是否有环
     *       判断链表环的入口
     *       输出链表的第k个节点
     */
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        if (head == null)
            return false;
        if (head.next == null)
            return false;
        if (head.next.next == null)
            return false;
        while (p.next != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == null || q == null)
                return false;
            if (p.val == q.val)
                return true;
        }
        return false;
    }

    /***
     * 先让快指针向前走k个,当快指针指向Null后，满指针指向的是倒数第k个、
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode frontNode = head, behindNode = head;
        while (frontNode != null && k > 0) {

            frontNode = frontNode.next;
            k--;
        }

        while (frontNode != null) {

            frontNode = frontNode.next;
            behindNode = behindNode.next;
        }

        return behindNode;
    }

    /***
     *将两指针分别放在链表头（X）和相遇位置（Z），并改为相同速度推进，则两指针在环开始位置相遇（Y）
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {                 //利用快慢指针找相遇点
                ListNode slow2 = head;    //设置以相同速度的新指针从起始位置出发
                while (slow2 != slow) {      //未相遇循环。
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
