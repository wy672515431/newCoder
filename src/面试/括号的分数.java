package 面试;

import java.util.Stack;

/***
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串
 *
 */
public class 括号的分数 {
        /***
         * 字符串S中的每一个位置都有一个深度，即该位置外层嵌套的括号数目。例如
         * 字符串(()(.()))中·所在的深度为2.我们使用栈来维护当前的深度，以及每一层的得分。每遇到一个(，深度加1，得分为0
         * 遇到一个)，将当前深度得分*2，加到上一层。
         * @param S
         * @return
         */
        public int scoreOfParentheses(String S) {
                Stack<Integer> stack = new Stack<>();
                //深度为0
                stack.push(0);
                for(int i=0;i<S.length();i++){
                        char ch = S.charAt(i);
                        if(ch == '('){
                                stack.push(0);
                        }else if(ch == ')'){
                                int tem1 = stack.pop();
                                int tem2 = stack.pop();
                                tem2 += Math.max(tem1*2,1);
                                stack.push(tem2);
                        }
                }
                return stack.pop();
        }
}
