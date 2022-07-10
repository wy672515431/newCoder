package 面试;

public class 排序 {
        private static final int inf = 0x3f3f3f3f;
        private  int ans = 0;
        public int[] MySort (int[] arr) {
                // write code here
                //主要考虑mergesort和quicksort
                //1.mergesort。主要思想为分治,递归进行mergesort然后进行merge。
                //mergeSort(arr,0,arr.length-1);
                //Arrays.sort(arr);
                quickSort(arr,0,arr.length-1);
                return arr;
        }
        //merge主要将两个排序好的数组合并成一个有序的数组
        public void merge(int[] arr,int p ,int q,int r){
                int length1 = q-p+1;
                int length2 = r-q;
                int[]  tem1 = new int[length1+1];
                int[]  tem2 = new int[length2+1];
                for(int i = p ;i<=q;i++)
                        tem1[i-p] = arr[i];
                tem1[q-p+1] = inf;
                for(int i =q+1;i<=r;i++)
                        tem2[i-q-1] = arr[i];
                tem2[r-q] = inf;
                int i=0,j=0,k;
                for(k =p;k<=r;k++){
                        if(i<length1&&tem1[i]<=tem2[j]){
                                arr[k] = tem1[i];
                                i++;
                        }
                        else{

                                arr[k] = tem2[j];
                                ans+=(length1-i);
                                j++;
                        }
                }
        }
        public void mergeSort(int[] arr,int p,int q){
                if(p<q){
                        int r = (p+q)>>1;
                        mergeSort(arr,p,r);
                        mergeSort(arr,r+1,q);
                        merge(arr,p,r,q);
                }
        }
        public int partition(int[] arr,int p,int q){
                int pivot = arr[p];
                int i = p;
                int j = q;
                while(i<j){
                        while(i<j&&arr[j]>pivot)
                                j--;
                        if(i<j){
                                arr[i] = arr[j];
                                i++;
                        }
                        while(i<j&&arr[i]<pivot)
                                i++;
                        if(i<j){
                                arr[j] =  arr[i];
                                j--;
                        }
                }
                arr[i] = pivot;
                return i;
        }

        public void quickSort(int[] arr,int p, int q){
                int pivot;
                if(p<q){
                        pivot = partition(arr,p,q);
                        quickSort(arr,p,pivot-1);
                        quickSort(arr,pivot+1,q);
                }
        }
        public void insertSort(int[] arr){
                for(int i=1;i<arr.length;i++){
                        int j;
                        //插入的那个元素
                        int tem  = arr[i];
                        for(j = i;j>0 && arr[j-1]>tem;j--){
                                arr[j] = arr[j-1];
                        }
                        arr[j] = tem;
                }
        }

        public static void main(String[] args) {
                int[] a = {2,3,4,2,1};
                new 排序().insertSort(a);
                for(int a1:a)
                        System.out.println(a1);
        }
}
