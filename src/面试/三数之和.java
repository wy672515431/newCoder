package 面试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    List<List<Integer>> ans = new ArrayList();

    /***
     * 这道题可以由三数之和，引申为四数之和，和k数之和。
     * 本质上都是双指针的用法。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    while (left < right && nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    }
                    if (left < right && nums[i] + nums[left] + nums[right] == 0) {
                        ArrayList tem = new ArrayList();
                        int tem1 = nums[left];
                        int tem2 = nums[right];
                        tem.add(nums[i]);
                        tem.add(nums[left]);
                        tem.add(nums[right]);
                        ans.add(tem);
                        while (left < right && nums[left] == tem1)
                            left++;
                        while (left < right && nums[right] == tem2)
                            right--;
                    }
                    while (left < right && nums[i] + nums[left] + nums[right] < 0)
                        left++;
                }
            }
        }
        return ans;
    }


    private List<List<Integer>> ans1 = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return ans1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (j != i + 1 && nums[j] == nums[j - 1])
                        continue;
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        while (left < right && nums[i] + nums[j] + nums[left] + nums[right] < target) {
                            left++;
                        }
                        if (left < right && nums[i] + nums[j] + nums[left] + nums[right] == target) {
                            List<Integer> tem = new ArrayList<>();
                            int tem1 = nums[left];
                            int tem2 = nums[right];
                            tem.add(nums[i]);
                            tem.add(nums[j]);
                            tem.add(nums[left]);
                            tem.add(nums[right]);
                            ans1.add(tem);
                            while (left < right && nums[left] == tem1) {
                                left++;
                            }
                            while (left < right && nums[right] == tem2) {
                                right--;
                            }
                        }
                        while (left < right && nums[i] + nums[j] + nums[left] + nums[right] > target) {
                            right--;
                        }
                    }
                }
            }
        }
        return ans1;
    }

}
