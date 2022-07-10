package 面试;

public class 寻找重复数 {
    /***
     * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
     *
     * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     *
     * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
     *
     * 我们分析如果这个数组不存在重复的数
     * 那么其的值必须包括1~n中的每个数
     * 以[1, 3, 2, 4]为例
     * 我们将数组的下标n和nums[n]建立一个映射。
     * 0 -> 1
     * 1 -> 3
     * 2 -> 2
     * 3 - > 4  0 -> 1 -> 3 -> 4 -> null是一个不存在环的链表
     *
     * 如果存在重复的数
     * [1,3,3,2]为例
     * 0 -> 1
     * 1 -> 3
     * 2 -> 3
     * 3 -> 2
     *
     * 0 -> 1 -> 3 -> 2 -> 3
     * 显然存在一个环，此时就变成了求环的入口
     * 这道题必有环
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
