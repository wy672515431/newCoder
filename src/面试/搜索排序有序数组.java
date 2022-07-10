package 面试;

public class 搜索排序有序数组 {
        public boolean search(int[] nums, int target) {
                int low = 0;
                int high = nums.length-1;
                int mid;
                while(low<=high){
                        mid = low+(high-low)/2;
                        if(nums[mid] == target)
                                return true;
                        //左边是有序的
                        if(nums[low]<nums[mid]){
                                if(nums[low]<=target && nums[mid]>target)
                                        high = mid-1;
                                else
                                        low = mid+1;
                        }else if(nums[low] == nums[mid]){
                                low = low+1;
                        }else{
                                if(nums[mid]<target && nums[high]>=target)
                                        low = mid+1;
                                else
                                        high = mid-1;
                        }
                }
                return false;
        }
}
