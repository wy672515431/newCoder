package 面试;

import java.util.HashMap;
import java.util.Stack;

/***
 * 非优化
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据。
 * 类似于单调栈的思想。如果主栈为空，则将元素进栈。如果栈顶元素大于等于遇到的元素，入栈。
 * 如果栈顶元素小于栈外元素，则将主栈的元素出栈直至栈顶元素大于等于栈外元素。
 * 此时出栈的元素是一个单调递增栈，将其在push到主栈中，则维护的仍是单调递减栈。
 *
 * 优化。我们可以充分利用辅助栈的性质。我们不用在每一次push的时候，将辅助栈的元素重新放到主栈中。
 * 当   stack2.peek() <= val<stack1.peek() 时，我们可以直接将val直接放到辅助栈里。
 */
public class 栈排序 {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        //遇到的元素小于栈顶的元素，入栈，如果大于栈顶的元素,栈顶元素出栈，将其放到另一个栈里。结束后，将另一个栈里的元素依次放到本栈中
        // 4 1 2 3
        public 栈排序() {
                stack1 = new Stack();
                stack2 = new Stack();
        }
        public void push(int val) {
                if(stack1.isEmpty())
                        stack1.push(val);
                else if(stack1.peek()<val){
                        // 7 6
                        // 2 3 1
                        while(!stack1.isEmpty()&&stack1.peek()<val){
                                stack2.push(stack1.pop());
                        }
                        stack1.push(val);
                }else if(stack2.isEmpty()||stack2.peek()<=val)
                        stack2.push(val);
                else{
                        while(!stack2.isEmpty()&&stack2.peek()>val){
                                stack1.push(stack2.pop());
                        }
                        stack2.push(val);
                }
                /*
                else{
                        while(!stack1.isEmpty()&&stack1.peek()<val){
                                stack2.push(stack1.pop());
                        }
                        stack1.push(val);
                        while(!stack2.isEmpty())
                                stack1.push(stack2.pop());
                }*/
        }

        public void pop() {
                while (!stack2.isEmpty())
                        stack1.push(stack2.pop());
                if(stack1.isEmpty())
                        return;
                stack1.pop();
        }

        public int peek() {
                while (!stack2.isEmpty())
                        stack1.push(stack2.pop());
                if(stack1.isEmpty())
                        return -1;
                return stack1.peek();
        }

        public boolean isEmpty() {
                return stack1.isEmpty();
        }

        public static void main(String[] args) {

        }
}
