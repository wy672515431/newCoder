package 面试;

import java.util.Stack;

public class 有效的括号字符串 {
    public static boolean checkValidString(String s) {
        Stack<Integer> leftBraceletStack = new Stack<>();
        Stack<Integer> starSignStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                leftBraceletStack.push(i);
            }else if(ch == '*') {
                starSignStack.push(i);
            }else if(ch == ')') {
                if(!leftBraceletStack.isEmpty()) {
                    leftBraceletStack.pop();
                }else if(!starSignStack.isEmpty()) {
                    starSignStack.pop();
                }else{
                    return false;
                }
            }
        }
        while (!leftBraceletStack.isEmpty()) {
            if(starSignStack.isEmpty())
                return false;
            else if(leftBraceletStack.peek() > starSignStack.peek()) {
                return false;
            }else {
                leftBraceletStack.pop();
                starSignStack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
