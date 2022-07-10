package 面试;

import java.util.Stack;

public class 表达式求值 {
        public int solve (String s) {
                // write code here
                //构造符号栈即可
                //栈顶优先级大于栈外优先级时,进制
                //反之出栈
                //符号栈
                Stack<Character> operators = new Stack();
                //运算符栈
                Stack<Integer> operands = new Stack();
                int or1=0,or2=0,sum=0;
                int len = s.length();
                for(int i=0;i<len;i++){
                        char ch = s.charAt(i);
                        if(ch=='+'||ch == '-' || ch=='*' || ch =='('|| ch ==')'){
                                if(operators.isEmpty())
                                        operators.push(ch);
                                else{
                                        if(ch == '+' || ch=='-'){
                                                char tem = operators.peek();
                                                if(tem=='+'||tem=='-'||tem=='*'){
                                                        operators.pop();
                                                        or1 = operands.pop();
                                                        or2 = operands.pop();
                                                        if(tem == '+'){
                                                                sum = or1+or2;
                                                                operands.push(sum);
                                                                operators.push(ch);
                                                        }
                                                        else if(tem == '-'){

                                                                sum = or2-or1;
                                                                operands.push(sum);
                                                                operators.push(ch);
                                                        }else if(tem == '*'){
                                                                sum = or1*or2;
                                                                operands.push(sum);
                                                                operators.push(ch);
                                                        }
                                                }else if(tem == '('){
                                                        operators.push(ch);
                                                }
                                        }else if(ch == '*'){
                                                char tem = operators.peek();
                                                if(tem == '*'){
                                                        operators.pop();
                                                        or1 = operands.pop();
                                                        or2 = operands.pop();
                                                        sum = or1*or2;
                                                        operands.push(sum);
                                                        operators.push(ch);
                                                }else{
                                                        operators.push(ch);
                                                }
                                        }else if(ch =='('){
                                                operators.push(ch);
                                        }else if(ch == ')'){
                                                while(operators.peek()!='('){
                                                        char tem = operators.pop();
                                                        or1 = operands.pop();
                                                        or2 = operands.pop();
                                                        switch(tem){
                                                                case '+':
                                                                        sum = or1+or2;
                                                                        operands.push(sum);
                                                                        break;
                                                                case '-':
                                                                        sum = or2-or1;
                                                                        operands.push(sum);
                                                                        break;
                                                                case '*':
                                                                        sum = or1*or2;
                                                                        operands.push(sum);
                                                        }
                                                }
                                                operators.pop();
                                        }

                                }
                        }else{
                                int tem = ch-'0';
                                i++;
                                while(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                                        tem = tem*10+(s.charAt(i)-'0');
                                        i++;
                                }
                                operands.push(tem);
                                i--;
                        }
                }
                while(!operators.isEmpty()){
                        char ch = operators.pop();
                        or1 = operands.pop();
                        or2 = operands.pop();
                        switch(ch){
                                case '+':
                                        sum = or1+or2;
                                        operands.push(sum);
                                        break;
                                case '-':
                                        sum = or2-or1;
                                        operands.push(sum);
                                        break;
                                case '*':
                                        sum = or1*or2;
                                        operands.push(sum);
                        }
                }
                return operands.peek();
        }
}
