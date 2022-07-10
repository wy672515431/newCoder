package 面试;

import java.util.HashMap;

public class 连续的子数组和 {
        /***
         * 给定一个包含 非负数 的数组和一个目标 整数 k ，
         * 编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，
         * 其中 n 也是一个整数。
         *我们知道一个数组[i,j]的和 = presum[j] - presum[i-1]
         * 如果(presum[j] - presum[i-1])%k == 0 等价于 presum[j]%k == presum[i-1] % k
         * 即我们在哈希表里面记录presum[j]%k的值，如果出现重复，则表明子数组的值为k的倍数。
         * @param nums
         * @param k
         * @return
         */
        public boolean checkSubarraySum(int[] nums, int k) {
                HashMap<Integer,Integer> map = new HashMap();
                int sum = 0;
                map.put(0,-1);
                //前缀和初始化
                for(int i=0;i<nums.length;i++){
                        sum+=nums[i];
                        if(k!=0){
                                sum = sum%k;
                        }
                        if(map.get(sum) == null){
                                map.put(sum,i);
                        }else{
                                if(i - map.get(sum) >1)
                                        return true;
                        }
                }
                return false;
        }
}
