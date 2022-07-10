package 面试;

public class 翻转对 {
    /***
     * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
     */
    private static final long inf = 2L << 32 - 1;
    private int ans = 0;

    public int reversePairs(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return ans;
    }

    private void merge(int[] arr, int p, int q, int r) {
        int length1 = q - p + 1;
        int length2 = r - q;
        long[] tem1 = new long[length1 + 1];
        long[] tem2 = new long[length2 + 1];
        for (int i = p; i <= q; i++)
            tem1[i - p] = arr[i];
        tem1[q - p + 1] = inf;
        for (int i = q + 1; i <= r; i++)
            tem2[i - q - 1] = arr[i];
        tem2[r - q] = inf;
        int i = 0, j = 0, k;
        while(i < length1 && j < length2) {
            if(tem1[i] > 2*tem2[j]) {
                ans += (length1 - i);
                j++;
            }else{
                i++;
            }
        }
        i = 0;
        j = 0;
        for (k = p; k <= r; k++) {
            if (tem1[i] >= tem2[j]) {
                arr[k] = (int) tem2[j];
                j++;
            } else {
                arr[k] = (int) tem1[i];
                i++;
            }
        }
    }

    private void mergesort(int[] arr, int p, int q) {
        if (p < q) {
            int r = (p + q) >> 1;
            mergesort(arr, p, r);
            mergesort(arr, r + 1, q);
            merge(arr, p, r, q);
        }
    }

    public static void main(String[] args) {
        new 翻转对().reversePairs(new int[]{1, 3, 2, 3, 1});
    }
}
