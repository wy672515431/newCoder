package 题目;

public class KthNumber {
        public static int findKth(int[] a, int n, int K) {
                return partition(a,0,n-1,K);
                // write code here
                //优先队列即可解决
        /*
        PriorityQueue<Integer> queue =  new PriorityQueue();

        for(int i = 0 ; i<n;i++){
            if(queue.size()!= K){
                queue.offer(a[i]);
            }else{
                if(queue.peek()<a[i]){
                    queue.poll();
                    queue.offer(a[i]);
                }
            }
        }
        return queue.peek();
        */

        }
        public static int partition(int[]a,int p,int q,int K){
                int pivot = a[p];
                int i = p;
                int j = q;
                while(i<j){
                        while(i<j&&a[j]<pivot){
                                j--;
                        }
                        if(i<j){
                                a[i] = a[j];
                                i++;
                        }
                        while(i<j&&a[i]>pivot){
                                i++;
                        }
                        if(i<j){
                                a[j]=a[i];
                                j--;
                        }
                }
                a[i] = pivot;
                if(i+1==K){
                        return a[i];
                }
                else if(i+1<K){
                       return partition(a,i+1,q,K);
                }else{
                      return   partition(a,p,i-1,K);
                }

        }

        public static void main(String[] args) {
                int[] a = {1,3,5,2,2};
                findKth(a,5,3);
        }
}
