package 面试;

import java.util.Arrays;
import java.util.Stack;

public class 找出数组中每个元素后边第一个比它大的值 {
        /***
         *
         * @param a
         * @return 返回值是一个数组,ans[i]代表数组a[i]后边第一个比它大的值，如果
         * ans[i]=Integer.MIN_VALUE,代表不存在
         */
        public int[] solve(int[] a){
                int[] ans = new int[a.length];
                Arrays.fill(ans,Integer.MIN_VALUE);
                //维护一个单调递减栈
                Stack<Integer> stack = new Stack<>();
                for(int i=0;i<a.length;i++){
                        if(stack.isEmpty()||a[stack.peek()]>=a[i])
                                stack.push(i);
                        else{
                                while (!stack.isEmpty()&&a[stack.peek()]<a[i]){
                                        int pos = stack.pop();
                                        ans[pos] = a[i];
                                }
                                stack.push(i);
                        }
                }
                return ans;
        }

        public static void main(String[] args) {
                int[] a= {8, 2, 5, 4, 3, 9, 7, 2, 5};
                int[] ans = new 找出数组中每个元素后边第一个比它大的值().solve(a);
                for(int i=0;i<ans.length;i++)
                        System.out.print(ans[i]+" ");
        }
}
