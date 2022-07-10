package 面试;

import java.util.ArrayList;
import java.util.List;

public class 计算右侧小于当前元素的个数 {
    private int[] ans;
    private static final int INF = 0x3f3f3f3f;

    public List<Integer> countSmaller(int[] nums) {
        MixedNums[] mixedNums = new MixedNums[nums.length];
        ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            mixedNums[i] = new MixedNums(nums[i], i);
        }
        mergesort(mixedNums, 0, nums.length - 1);
        List<Integer> ans1 = new ArrayList();
        for (int num : ans) {
            ans1.add(num);
        }
        return ans1;
    }

    private void merge(MixedNums[] mixedNums, int p, int q, int r) {
        int length1 = q - p + 1;
        int length2 = r - q;
        MixedNums[] tem1 = new MixedNums[length1 + 1];
        MixedNums[] tem2 = new MixedNums[length2 + 1];
        for (int i = p; i <= q; i++) {
            tem1[i - p] = mixedNums[i];
        }
        tem1[q - p + 1] = new MixedNums(INF, mixedNums.length + 1);
        for (int i = q + 1; i <= r; i++) {
            tem2[i - q - 1] = mixedNums[i];
        }
        tem2[r - q] = new MixedNums(INF, mixedNums.length + 1);
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (tem1[i].value > tem2[j].value) {
                mixedNums[k] = tem2[j];
                j++;
            } else {
                ans[tem1[i].pos] += j;
                mixedNums[k] = tem1[i];
                i++;
            }
        }
    }

    private void mergesort(MixedNums[] mixedNums, int p, int r) {
        if (p < r) {
            int q = (p + r) >> 1;
            mergesort(mixedNums, p, q);
            mergesort(mixedNums, q + 1, r);
            merge(mixedNums, p, q, r);
        }
    }

    class MixedNums {
        int value;
        int pos;

        public MixedNums(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }


    public static void main(String[] args) {
        new 计算右侧小于当前元素的个数().countSmaller(new int[]{5, 2, 6, 1});
    }
}
