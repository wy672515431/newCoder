package 面试;

/***
 * 最长递增字串
 */
public class 最长连续递增序列 {
        public int findLengthOfLCIS(int[] nums) {
                if(nums.length == 0)
                        return 0;
                int len = 1;
                int ans = 1;
                for(int i=1;i<nums.length;i++){
                        if(nums[i]>nums[i-1]){
                                len++;
                        }else{
                                len = 1;
                        }
                        ans = Math.max(ans,len);
                }
                return ans;
        }
}
