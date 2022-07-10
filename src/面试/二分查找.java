package 面试;

public class 二分查找 {
        public int GetNumberOfK(int [] array , int k) {
                int pos = lowerBound(array,k);
                int pos1 = upperBound(array,k);
                if(pos==-1||pos1==-1)
                        return 0;
                else
                        return pos1-pos;
        }
        //返回第一个大于等于k的下标
        public int lowerBound(int[] array,int k){
                int low = 0;
                int high = array.length-1;
                int mid;
                while(low<high){
                        mid=(low+high)>>1;
                        if(array[mid]>=k){
                                high = mid;
                        }else{
                                low = mid+1;
                        }
                }
                return low;
        }
        //返回第一个大于k的下标
        public int upperBound(int[] array,int k){
                if(array[array.length-1]<=k)
                        return array.length;
                int low = 0;
                int high = array.length-1;
                int mid;
                while(low<high){
                        mid=(low+high)>>1;
                        if(array[mid]<=k){
                                low = mid+1;
                        }else{
                                high = mid;
                        }
                }
                return low;
        }

        public static void main(String[] args) {
                int[] a = {3};
                new 二分查找().GetNumberOfK(a,3);
        }
}
