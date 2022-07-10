package 面试;

/***
 * 一个栈的栈底在数组下标为0的地方，另一个栈的栈底在数组下标最大的地方。
 * 前者向左扩展，后者向右扩展。
 * 这样空间利用率会最大
 */
public class 一个数组实现两个栈 {
        //栈1的指针
        private static int top1;
        //栈2的指针
        private static int top2;
        //数组
        private Integer[] elements;
        public 一个数组实现两个栈(int size){
                elements = new Integer[size];
                //两栈为空
                top1 = -1;
                top2 = size;
        }
        /***
         *
         * @param val 进栈的值
         * @param stackNum 进哪个栈
         */
        public void push(int val,int stackNum){
                if(top1+1 == top2)
                        throw new RuntimeException("空间溢出");
                if(stackNum == 1){
                        elements[++top1] = val;
                }else if(stackNum == 2){
                        elements[--top2] = val;
                }else{
                        throw  new RuntimeException("stackNum不在范围内");
                }
        }
        public int pop(int stackNum){
                if(stackNum == 1){
                        if(top1<0){
                                //return;
                                throw new RuntimeException("EmptyStack");
                        }
                        int tem = elements[top1];
                        elements[top1--] = null;
                        return tem;
                }else{
                        if(top2>=elements.length)
                                throw new RuntimeException("EmptyStack");
                        int tem = elements[top2];
                        elements[top2++] = null;
                        return tem;
                }
        }
        public int peek(int stackNum){
                if(stackNum == 1){
                        if(top1<0){
                                //return;
                                throw new RuntimeException("EmptyStack");
                        }
                        return elements[top1];
                }else{
                        if(top2>=elements.length)
                                throw new RuntimeException("EmptyStack");
                        return elements[top2];
                }
        }
}

