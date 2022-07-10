package 面试;

public class 所有奇数长度子数组的和 {
    /***
     * 前缀和解决
     * @param arr
     * @return
     */
    public int sumOddLengthSubArrays(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        //初始话为0
        prefixSum[0] = 0;
        //求取前缀和
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        int ans = 0;
        for (int length = 1; length <= arr.length; length += 2) {
            for (int j = 1; j < prefixSum.length; j++) {
                if (j + length - 1 < prefixSum.length)
                    ans += prefixSum[j + length - 1] - prefixSum[j - 1];
                else
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new 所有奇数长度子数组的和().sumOddLengthSubArrays(new int[]{1, 4, 2, 5, 3});
        System.out.println(new 所有奇数长度子数组的和().sumOddLengthSubArrays(new int[]{1, 4, 2, 5, 3}));
    }
}
