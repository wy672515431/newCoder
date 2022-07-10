package 面试;

public class 乘积最大子数组 {
    /***
     * 找出数组中乘积最大的连续子数组
     * 这道题为动态规划,对于乘法，我们知道，负数乘以负数可以变成正数，所以我们也要维护一个最小值。
     * 我们不妨令imax为最大值,则新的为imax = Math.max(imax * a[i], a[i]);
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                int tem = imax;
                imax = imin;
                imin = tem;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(imax, max);
        }
        return max;
    }
}
