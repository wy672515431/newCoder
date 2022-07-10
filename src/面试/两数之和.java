package 面试;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 两数之和 {
        /**
         * 1.暴力枚举 复杂度O(N^2)
         * 2.排序双指针 复杂度O(NLOGN)
         * 3.哈希表 复杂度O(N)
         * */
        private int[] ans = new int[2];
        public int[] twoSum2(int[] nums, int target) {
                Mixed[] replica = new Mixed[nums.length];
                for(int i=0;i<nums.length;i++){
                        Mixed tem = new Mixed(nums[i],i);
                        replica[i] = tem;
                }
                Arrays.sort(replica,new Comparator<Mixed>(){
                        @Override
                        public int compare(Mixed o1,Mixed o2){
                                return o1.num - o2.num;
                        }
                });
                //双指针
                int i = 0;
                int j = replica.length-1;
                while(i<j){
                        if(replica[i].num+replica[j].num == target){
                                ans[0] = replica[i].pos;
                                ans[1] = replica[j].pos;
                                break;
                        }else if(replica[i].num+replica[j].num < target){
                                i++;
                        }else{
                                j--;
                        }
                }
                return ans;
        }
        private HashMap<Integer,Integer> map = new HashMap();
        public int[] twoSum3(int[] nums, int target) {
                for(int i=0;i<nums.length;i++){
                        if(map.get(target - nums[i]) != null){
                                ans[0] = i;
                                ans[1] = map.get(target - nums[i]);
                                break;
                        }
                        map.put(nums[i],i);
                }
                return ans;
        }
        private static class Mixed{
                int num;
                int pos;
                public Mixed(int num,int pos){
                        this.num = num;
                        this.pos = pos;
                }
        }
}
