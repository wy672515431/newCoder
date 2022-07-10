package 面试;

import java.util.Arrays;

/***
 * 子序列
 */
public class 最长递增子序列 {
        public int lengthOfLIS(int[] nums) {
                if(nums.length == 0)
                        return 0;
                int cnt = 0;
                int[] dp = new int[nums.length];
                dp[0] = nums[0];
                for(int i=1;i<nums.length;i++){
                        if(nums[i]>dp[cnt]){
                                dp[++cnt] = nums[i];
                        }else{
                                int pos = lowerBound(dp,nums[i],cnt);
                                dp[pos] = nums[i];
                        }
                }
                return  cnt+1;
        }

        /***
         * 找到第一个大于等于target的下标
         * @param dp
         * @param target
         * @return
         */
        public int lowerBound(int[] dp,int target,int cnt){
                int low = 0;
                int high = cnt;
                int mid;
                while (low<high){
                        mid =(low+high)>>1;
                        if(dp[mid]>=target)
                                high = mid;
                        else
                                low = mid+1;
                }
                return low;
        }

        /***
         * 求个数
         * dp[i]:到nums[i]为止的最长递增子序列长度
         * count[i]:到nums[i]为止的最长递增子序列个数
         */
        public int findNumberOfLIS(int[] nums) {
                int n = nums.length;
                if(n == 1)
                        return 1;
                int[] dp = new int[n];
                int[] count = new int[n];
                Arrays.fill(dp,1);
                Arrays.fill(count,1);
                int maxLength = 0;
                for(int i=1;i<n;i++){
                        for(int j=0;j<i;j++){
                                if(nums[i] > nums[j]){
                                        if(dp[j]+1 > dp[i]){
                                                dp[i] =  dp[j]+1;
                                                count[i] = count[j];
                                        }else if(dp[j]+1 == dp[i]){
                                                count[i] += count[j];
                                        }
                                }
                        }
                        maxLength = Math.max(maxLength,dp[i]);
                }
                int ans = 0;
                for(int i=0;i<n;i++){
                        if(dp[i] == maxLength)
                                ans += count[i];
                }
                return ans;
        }
}
