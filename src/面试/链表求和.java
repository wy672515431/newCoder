package 面试;

import java.util.List;

public class 链表求和 {
        /***
         * 低位在链表头部
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode dummy = new ListNode(-1);
                ListNode cur = dummy;
                int cnt = 0;
                int sum = 0;
                int add1 = 0;
                int add2 = 0;
                while(l1!=null || l2!=null || cnt!=0){
                        add1 = (l1!=null)?l1.val:0;
                        add2 = (l2!=null)?l2.val:0;
                        sum = add1+add2+cnt;
                        cnt = sum/10;
                        cur.next = new ListNode(sum%10);
                        l1 = (l1!=null)?l1.next:null;
                        l2 = (l2!=null)?l2.next:null;
                        cur = cur.next;
                }
                return dummy.next;
        }

        /***
         * 高位在前面
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
                l1 = reverseList(l1);
                l2 = reverseList(l2);
                ListNode dummy = new ListNode(-1);
                ListNode cur = dummy;
                int cnt = 0;
                int sum = 0;
                int add1 = 0;
                int add2 = 0;
                while(l1!=null || l2!=null || cnt!=0){
                        add1 = (l1!=null)?l1.val:0;
                        add2 = (l2!=null)?l2.val:0;
                        sum = add1+add2+cnt;
                        cnt = sum/10;
                        cur.next = new ListNode(sum%10);
                        l1 = (l1!=null)?l1.next:null;
                        l2 = (l2!=null)?l2.next:null;
                        cur = cur.next;
                }
                return reverseList(dummy.next);
        }

        /***
         * 有符号大整数加法
         * //两个都是负数,绝对值相加，取负数
         * //两个都是正数，直接相加即可。
         * //一个是正数一个是负数,相当于是正数减去负数的绝对值
         * 只考虑第三种情况
         * @param l1 已经去除符号的链表
         * @param l2 已经去除的符号链表
         * @return 默认高位在前面
         */
        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
                //二者都是负数
                if(l1.val == -1 && l2.val == -1){
                        l1 = l1.next;
                        l2 = l1.next;
                        return addTwoNumbers1(l1,l2);
                }else if(l1.val>=0&&l2.val>=0){
                        return addTwoNumbers1(l1,l2);
                }else if(l1.val == -1 && l2.val>=0){
                        //l1的绝对值大于l2的绝对值,二者相减后添加负号
                        if(compare(l1.next,l2) == l1.next){
                                ListNode tem = subtractTwoNumbers(l1.next,l2);
                                ListNode dummy = new ListNode(-1);
                                dummy.next = tem;
                                return dummy;
                        }else{
                                return subtractTwoNumbers(l2,l1.next);
                        }
                }else if(l1.val>=0&&l2.val == -1){
                        if(compare(l2.next,l1) == l2.next){
                                ListNode tem = subtractTwoNumbers(l2.next,l1);
                                ListNode dummy = new ListNode(-1);
                                dummy.next = tem;
                                return dummy;
                        }else{
                                return  subtractTwoNumbers(l1,l2.next);
                        }
                }
                return null;
        }

        /***
         * 高位在头,l1的值大于l2的值
         * @param l1
         * @param l2
         * @return
         */
        public ListNode subtractTwoNumbers(ListNode l1,ListNode l2){
                l1 = reverseList(l1);
                l2 = reverseList(l2);
                ListNode dummy = new ListNode(-1);
                ListNode cur  = dummy;
                int sum = 0;
                int sub1 = 0;
                int sub2 = 0;
                //找上一位借的
                int cnt = 0;
                // 1 3 9
                // 2 3 8
                while (l1!=null||l2!=null||cnt!=0){
                        sub1 = (l1!=null)?l1.val-cnt:0;
                        sub2 = (l2!=null)?l2.val:0;
                        cnt = 0;
                        if(sub1<sub2){
                                sub1+=10;
                                cnt = 1;
                        }
                        sum = sub1-sub2;
                        cur.next = new ListNode(sum);
                        cur = cur.next;
                        l1 = (l1!=null)?l1.next:null;
                        l2 = (l2!=null)?l2.next:null;
                }
                //含有前导0;
                ListNode tem = reverseList(dummy.next);
                while(tem!=null&&tem.val == 0){
                        if(tem.next == null)
                                break;
                        tem = tem.next;
                }
                return tem;
        }
        public ListNode compare(ListNode l1,ListNode l2){
                String s1 = "";
                String s2 = "";
                ListNode cur = l1;
                StringBuilder sb = new StringBuilder();
                while(cur!=null){
                        sb.append(l1.val);
                        cur = cur.next;
                }
                s1 = sb.toString();
                sb.setLength(0);
                cur = l2;
                while (cur!=null){
                        sb.append(l2.val);
                        cur = cur.next;
                }
                s2 = sb.toString();
                return s1.compareTo(s2)>0?l1:l2;
        }
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
                return dummy.next;

        }

        public static void main(String[] args) {
                ListNode l1 = new ListNode(9);
                ListNode node = new ListNode(3);
                ListNode node1 = new ListNode(1);
                //ListNode node2 = new ListNode(1);
                l1.next = node;
                node.next = node1;
                //node1.next = node2;
                ListNode l2 = new ListNode(9);
                ListNode l3 = new ListNode(3);
                ListNode l4 = new ListNode(1);
                l2.next = l3;
                l3.next = l4;
                ListNode ans = new 链表求和().addTwoNumbers2(l1,l2);
                while (ans != null){
                        if(ans.val == -1){
                                System.out.print('-');
                        }else
                                System.out.print(ans.val);
                        ans = ans.next;
                }

        }
}
