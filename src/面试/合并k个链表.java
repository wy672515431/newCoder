package 面试;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并k个链表 {
        /***
         * 优先队列
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists){
                PriorityQueue<ListNode> priorityQueue  = new PriorityQueue<>(new Comparator<ListNode>() {
                        @Override
                        public int compare(ListNode o1, ListNode o2) {
                                return  o1.val - o2.val;
                        }
                });
                if(lists == null)
                        return  null;
                ListNode head = new ListNode(-1);
                for(ListNode listNode : lists)
                        priorityQueue.offer(listNode);
                while (!priorityQueue.isEmpty()){
                        ListNode tem = priorityQueue.poll();
                        head.next = tem;
                        head = tem;
                        if(tem.next!=null)
                                priorityQueue.offer(tem.next);
                }
                return head.next;
        }

        /***
         * 归并算法
         * @param lists
         * @return
         */
        public ListNode mergeKLists1(ListNode[] lists){
                return merge(lists,0,lists.length-1);
        }
        public ListNode merge(ListNode[] lists,int p,int q){
                if(p == q){
                        return lists[p];
                }else if(p>q){
                        return  null;
                }
                int r = (p+q)>>1;
                return mergeTwoLists(merge(lists,p,r),merge(lists,r+1,q));
        }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2){
                if(l1 == null)
                        return l2;
                if(l2 == null)
                        return l1;
                ListNode head = new ListNode(0);
                ListNode cur  = head;
                ListNode tem1 = l1;
                ListNode tem2 = l2;
                while(tem1!=null&&tem2!=null){
                        if(l1.val<l2.val){
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
                return  head.next;
        }

}
