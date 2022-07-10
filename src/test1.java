import java.util.*;


public class test1 {
        /***
         *
         * @param a 进行逆置的数组
         * @param k 逆置的个数
         */
        public static void reverseArray (int[] a,int k) {
                for(int i = 0,j=k-1;i<j;i++,j--){
                        int tem = a[i];
                        a[i] = a[j];
                        a[j] = tem;
                }
        }

        /***
         * 删除数组下标i~j的元素
         * @param a
         * @param i
         * @param j
         */
        public static void deleteArray(int a[],int i , int j){
                for(int k  = j+1;k<a.length;k++){
                        a[i+k-j-1] = a[k];
                }
        }

        /***
         * 将数组中大于第一个元素的元素放在前半部分，小于第一个元素的放在后半部分。
         * @param a
         */
        public static  void moveArray(int a[]){
                int i  =0;
                int j = a.length-1;
                int tem = a[0];
                while (i<j){
                        while (a[j]>tem&&i<j){
                                j--;
                        }
                        if(i<j){
                                a[i] = a[j];
                                i++;
                        }
                        while(i<j&&a[i]<tem)
                                i++;
                        if(i<j){
                                a[j] = a[i];
                                j--;
                        }
                }
                a[i] = tem;
        }
        public static void main(String[] args) {
                int[] a = {4,2,3,6,7};
                moveArray(a);
                //reverseArray(a,4);
                //deleteArray(a,1,5);
                //for(int i = 0 ; i<5;i++)
                        //System.out.println(a[i]);
                ListNode head = new ListNode(-1);
                ListNode node1 = new ListNode(-1);
                ListNode node2  = new ListNode(-1);
                head.next = node1;
                node1.next = node2;
                byte[] ans = new byte[]{(byte)(-3&0xffff)};
                int ans1;
                for(int i=0;i<ans.length;i++){
                        System.out.println(ans[i]);
                }
        }
}
class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
                val = x;
                next = null;
        }
}