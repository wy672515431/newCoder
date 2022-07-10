package 面试;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 和至少为k的最短子数组 {
    /***
     * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
     *
     * 如果没有和至少为 K 的非空子数组，返回 -1
     *
     * 用P表示数组A的前缀和，我们要找的就是P(Y) - P(X) >= k 且 Y - X 最小即可
     *
     * 维护一个队列。对于每个y，找出满足，P[y]-P[x]>=K的最大的x。如果y-x比之前的长度要小就记录新的最小值。
     * 对于新加入的y，之前P[?]比它大的都pop掉。
     * 如果P[y] - P[x] > =k，计算完之后将x pop掉。
     * @param nums
     * @param k
     * @return
     */
    public int shortestSubarray(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int y = 0; y < prefixSum.length; y++) {
            while (!deque.isEmpty() && prefixSum[deque.peekLast()] >= prefixSum[y]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && prefixSum[y] - prefixSum[deque.peekFirst()] >= k) {
                ans = Math.min(y - deque.peekFirst(), ans);
                deque.removeFirst();
            }
            deque.addLast(y);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
