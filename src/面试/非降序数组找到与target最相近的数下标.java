package 面试;

public class 非降序数组找到与target最相近的数下标 {
        public int solve(int[] nums,int target){
                int pos = lowerBound(nums,target);
                int pos1 = upperBound(nums,target);
                //表明原数组有target
                if(pos1-pos>0){
                        return pos;
                }else{
                        if(nums[pos]-target>target-nums[pos-1])
                                return lowerBound(nums,nums[pos-1]);
                        else
                                return pos;
                }
        }
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
