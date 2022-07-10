package 面试;

public class 二分 {

        // 1 2 2 2 3
        public int lowerBound(int[] a,int target){
                int low = 0;
                int high = a.length-1;
                int mid;
                while (low<high){
                        mid = low+(high-low)/2;
                        if(a[mid]>=target){
                                high = mid;
                        }else{
                                low = mid+1;
                        }
                }
                return low;
        }
        public int upperBound(int[] a,int target){
                // 1 2 2 2 3
                int low = 0;
                int high = a.length-1;
                int mid;
                if(a[high]<=target)
                        return a.length;
                while (low<high){
                        mid = low+(high-low)/2;
                        if(a[mid]<=target)
                                low = mid+1;
                        else
                                high = mid;
                }
                return low;
        }
}
