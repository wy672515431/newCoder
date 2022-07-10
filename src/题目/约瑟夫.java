package 题目;

public class 约瑟夫 {
        /***
         * 解决约瑟夫问题，纯数学方法不好思考，直接采用环形链表进行模拟
         * @param n
         * @param m
         * @return
         */
        public int ysf(int n, int m){
                ListNode dummy = new ListNode(-1);
                //采用尾插法建表
                ListNode r = dummy;
                for(int i=1;i<=n;i++){
                        ListNode tem = new ListNode(i);
                        r.next = tem;
                        //循环链表
                        tem.next = dummy;
                        r = tem;
                }
                int cnt=0;
                ListNode prev = dummy;
                r = dummy.next;
                while (dummy.next.next!=dummy){
                        if(r == dummy){
                                prev = r;
                                r = dummy.next;
                        }
                        else{
                                cnt++;
                                if(cnt == m){
                                        prev.next = r.next;
                                        r = r.next;
                                        cnt=0;
                                }else{
                                        prev = r;
                                        r = r.next;
                                }
                        }

                }
                return dummy.next.val;
        }

        /***
         * 纯数学解法
         * solve(n.m)表示长度n，第m个数字，最后剩下的数字
         * @param n
         * @param m
         * @return
         * **问题一**：有n个数的时候，划掉了谁？**下标**是多少？
         *
         * 因为要从0数m个数，那最后肯定落到了下标为m-1的数身上了，但这个下标可能超过我们有的最大下标（n-1）了。所以攒满n个就归零接着数，逢n归零，所以要模n。
         *
         * 所以有n个数的时候，我们划掉了下标为(m-1)%n的数字。
         *
         * **问题二**：我们划完了这个数，往后数x+1下，能落到谁身上呢，它的下标是几？
         *
         * 你往后数x+1，它下标肯定变成了(m-1)%n +x+1，和第一步的想法一样，你肯定还是得取模，所以答案为[(m-1)%n+x+1]%n，则
         *
         * f(n,m)=[(m-1)%n+x+1]%n
         * 其中x=f(n-1,m)
         * f(n,m)=[(m-1)%n+x+1]%n
         *       =[(m-1)%n%n+(x+1)%n]%n
         *       =[(m-1)%n+(x+1)%n]%n
         *       =(m-1+x+1)%n
         *       =(m+x)%n
         */
        public int lastRemaining(int n, int m) {
                return solve(n,m);
        }
        public int solve(int n,int m){
                if(n==1)
                        return 0;
                int x = solve(n-1,m);
                return (m+x)%n;
        }
}
class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
                this.val = val;
                this.next = null;
        }
}
