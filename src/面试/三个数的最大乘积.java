package 面试;

import java.util.Arrays;

public class 三个数的最大乘积 {
        /***
         * 三个数最大的乘积 = Math.max{三个最大数的乘积,一个最大数与两个最小数的乘积}
         * 我们来验证一下
         * 如果一个数组全为负数 -9  -8 -7 -4 -2 -1
         * 三个数的乘积恒为负，显然此时最大乘积为三个最大数的乘积，即-4,-2,-1
         * 如果一个数组全为整数 9 8 7 4 2 1
         * 显然此时最大乘积为三个最大数的乘积，9 8 7
         * 数组中有正有负
         * -4 -3 -1 2 3 4
         * 2*3*4<(-4*-3*-1)
         * 最大值为一个最大数与两个最小数的乘积
         * 方法一，将数组排序，复杂度O(nlogn)
         * 方法二，老老实实求三个最大数和两个最小数 复杂度O(n);
         * @param nums n>=3
         * @return
         */
        public int maximumProduct(int[] nums){
                Arrays.sort(nums);
                int n  = nums.length;
                //假设不溢出
                return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-1]*nums[n-2]*nums[n-3]);
        }
        public  int maximumProduct1(int[] nums){
                int max1 = Integer.MIN_VALUE;
                int max2 = Integer.MIN_VALUE;
                int max3 = Integer.MIN_VALUE;
                int min1 = Integer.MAX_VALUE;
                int min2 = Integer.MAX_VALUE;
                for(int i=0;i<nums.length;i++){
                        if(nums[i]>=max1){
                                int tem = max1;
                                int tem1 = max2;
                                max1 = nums[i];
                                max2 = tem;
                                max3 = tem1;
                        }else if(nums[i]>=max2){
                                int tem = max2;
                                max2 = nums[i];
                                max3 = tem;
                        }else if(nums[i]>=max3){
                                max3 = nums[i];
                        }
                        if(nums[i]<=min1){
                                int tem = min1;
                                min1 = nums[i];
                                min2 = tem;
                        }else if(nums[i]<=min2){
                                min2 = nums[i];
                        }
                }
                return Math.max(max1*max2*max3,max1*min1*min2);
        }
}
