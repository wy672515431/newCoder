package 面试;

import java.util.Stack;

public class 移掉k位数字 {
        public String removeKdigits(String num, int k) {
                Stack<Character> stack = new Stack();
                for(int i=0;i<num.length();i++){
                        char ch = num.charAt(i);
                        while(!stack.isEmpty()&&k>0&&stack.peek()>ch){
                                stack.pop();
                                k--;
                        }
                        stack.push(ch);
                }
                for(int i=0;i<k;i++)
                        stack.pop();
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty())
                        sb.append(stack.pop());
                if(sb.length() == 0)
                        return "0";
                sb = sb.reverse();
                int pos = sb.length()-1;
                for(int i=0;i<sb.length();i++){
                        if(sb.charAt(i) != '0'){
                                pos = i;
                                break;
                        }
                }
                return sb.toString().substring(pos,sb.length());
        }
}
