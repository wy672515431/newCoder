package 题目;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueue {
        public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
                PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
                        @Override
                        public int compare(Integer o1,Integer o2){
                                return o2-o1;
                        }
                });
                ArrayList<Integer> ans = new ArrayList();
                if(k>input.length)
                        return ans;
                if(k==0)
                        return null;
                for(int i = 0 ;i<input.length;i++){
                        if(queue.size()!=k){
                                queue.add(input[i]);
                        }else{
                                if(input[i]<queue.peek()){
                                        queue.poll();
                                        queue.add(input[i]);
                                }
                        }
                }
                for(Integer tem : queue){
                        ans.add(tem);
                }
                return ans;
        }
        public static void main(String[] args) {
                int[] a ={4,5,1,6,2,7,3,8};
                GetLeastNumbers_Solution(a,0);
        }
}
