package 题目;

import java.util.Stack;

/***
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 
 * 被定义为：当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 *
 */
public class 单调栈 {
        /***
         * 单调栈
         * 单调递增栈：从栈底到栈顶为递增的
         * 单调递减栈:从栈底到栈顶递减的
         * 单调栈的pop和Push操作:
         * 单调递减栈为例:如果栈为空或者栈顶元素大于正在处理的元素，进栈
         *               若果栈顶元素小于正在处理的元素，栈顶元素出栈。
         * 对于上述这道题，我们可以针对2维持一个单调递减栈。当处理的元素大于栈顶时，我们便更新2的数值，然后
         * 使弹出的值作为3.这样会保证3的值尽可能的大，如果前面找到一个比3小的值，即满足132模式。
         */
        private int middle = Integer.MIN_VALUE;
        private Stack<Integer> stack = new Stack();
        public boolean find132pattern(int[] nums) {
                for(int i=nums.length-1; i>=0; i--){
                        if(nums[i]<middle)
                                return true;
                        while(!stack.isEmpty() && stack.peek()<nums[i])
                                middle = stack.pop();
                        stack.push(nums[i]);
                }
                return false;
        }

}
