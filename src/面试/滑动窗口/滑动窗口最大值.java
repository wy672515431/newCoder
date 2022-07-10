package 面试.滑动窗口;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 滑动窗口最大值 {
    /***
     * 滑动窗口主要应用于数组和字符串上。由于区间连续，因此当区间发生变化时们，可以通过旧有的计算结果对搜索空间进行剪枝，减少了重复计算，降低了
     * 时间复杂度。
     * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口中的最大值。
     * nums = [1,3,-1,-3,5,3,6,7], k = 3
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int right = 0;
        while (right < nums.length) {
            while (!deque.isEmpty() && nums[right] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.add(nums[right]);
            right++;
            if (right >= k) {
                ans.add(deque.peekFirst());
                if (deque.peekFirst() == nums[right - k]) {
                    deque.removeFirst();
                }
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
       int[] tem =  maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
       for(int tem1 : tem){
           System.out.println(tem1);
       }
    }
}
