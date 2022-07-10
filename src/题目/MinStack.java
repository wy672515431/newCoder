package 题目;

import java.util.Stack;

public class MinStack {
        Stack<Integer> stack;
        Stack<Integer> stack1;
        /** initialize your data structure here. */
        public MinStack() {
                stack = new Stack();
                stack1 = new Stack();
        }

        public void push(int x) {
                stack.push(x);
                if(stack1.isEmpty()||stack1.peek()>=x){
                        stack1.push(x);
                }
        }

        public void pop() {
                //不在常数池里
                if(stack1.peek().equals(stack.peek()))
                        stack1.pop();
                stack.pop();
        }

        public int top() {
                return stack.peek();
        }

        public int min() {
                return stack1.peek();
        }

        public static void main(String[] args) {
                MinStack minStack = new MinStack();
                minStack.push(512);
                minStack.push(-1024);
                minStack.push(-1024);
                minStack.push(512);
                minStack.pop();
                minStack.min();
                minStack.pop();
                minStack.min();
                minStack.pop();
                minStack.min();
        }
}
