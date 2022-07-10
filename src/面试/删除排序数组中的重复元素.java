package 面试;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class 删除排序数组中的重复元素 {
        //双指针
        public int removeDuplicates(int[] nums) {
                if(nums.length<=2)
                        return nums.length;
                int sp = 1;
                int fp = 2;
                for(;fp<nums.length;fp++){
                        if((nums[fp]!=nums[sp])||(nums[fp]!=nums[sp-1])){
                                nums[++sp] = nums[fp];
                        }
                }
                return sp+1;
        }

        /***
         * 删除一个重复元素
         * @param nums
         * @return
         */
        public int removeDuplicates1(int[] nums) {
                if(nums.length<=1)
                        return nums.length;
                int sp = 0;
                int fp = 1;
                for(;fp<nums.length;fp++){
                        if(nums[fp]!=nums[sp]){
                                nums[++sp] = nums[fp];
                        }
                }
                return sp+1;
        }

        public static void main(String[] args) {

        }
}
