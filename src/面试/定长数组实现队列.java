package 面试;

public class 定长数组实现队列 {
        /***
         * arr定长数组
         * size为队列当前的剩余大小
         * front为队列的头节点
         * last为队列的尾节点.
         */
        private  int[] arr;
        private  int size;
        private  int front;
        private  int last;
        public 定长数组实现队列(int initsize){
                this.arr = new int[size];
                this.size = initsize;
                this.front = 0;
                this.last = 0;
        }
        public void push(int data){
                if(size == 0)
                        throw new RuntimeException("队列已满");
                arr[front] = data;
                front = (front+1)%arr.length;
                size --;
        }
        public int pop(){
                if(size == arr.length)
                        throw new RuntimeException("队列已空");
                int ans = arr[last];
                last = (last+1)%arr.length;
                size++;
                return  ans;
        }
}
