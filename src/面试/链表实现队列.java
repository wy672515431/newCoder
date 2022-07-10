package 面试;

import java.util.LinkedList;
import java.util.Queue;

public class 链表实现队列 {
        private ListNode head;//链表的头节点
        private ListNode cur;//链表的当前节点
        private int size;
        private int maxSize;
        public 链表实现队列(int initsize){
                this.maxSize = initsize;
                head = new ListNode(-1);
                cur = head;
        }
        public void add(int data){
                if(size == maxSize)
                        throw  new RuntimeException("队列满了");
                size++;
                ListNode tem = new ListNode(data);
                cur.next = tem;
                cur = tem;
        }
        public int poll(){
                if(size == 0)
                        throw new RuntimeException("队列为空");
                size--;
                int ans = head.next.val;
                head.next = head.next.next;
                return  ans;
        }
}
