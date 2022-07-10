package 面试;

public class 用二分法对数字开根号 {
        public int sqrt(int x){
                if(x<2)
                        return x;
                int low = 1;
                int high  = x/2;
                int mid,last_mid = 0;
                while (low<=high){
                        mid = low+(high-low)/2;
                        if(x/mid>mid){
                                low = mid+1;
                                last_mid = mid;
                        }else if(x/mid<mid)
                                high = mid-1;
                        else
                                return  mid;
                }
                return last_mid;
        }
}
