package 面试;

import java.util.HashMap;

/***
 * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0.
 */
public class 和等于K的最长子数组长度 {
        HashMap<Integer,Integer> map = new HashMap();
        public int maxSubArrayLen(int[] nums, int k) {
                int sum = 0;
                int ans = 0;
                map.put(0,-1);//前缀和初始化为0，起始位置为-1.
                for(int i=0;i<nums.length;i++){
                        sum+=nums[i];
                        if(map.containsKey(sum-k)){
                                int tem = map.get(sum-k);
                                ans = Math.max(ans,i-tem);
                        }
                        if(map.get(sum) == null)
                                map.put(sum,i);
                }
                return ans;
        }
}
