package 面试;

public class 合并排序的数组 {
    /***
     * 如果可以构建一个中间数组非常简单。
     * 为什么要构建一个中间数组，因为正向双指针可能覆盖
     * 我们不妨考虑逆向双指针
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        // m + n -1 表示最大值 j + i + 1
        while(i >= 0 && j >= 0) {
            if(B[j] >= A[i]) {
                A[j + i + 1] = B[j];
                j --;
            }else{
                A[j + i + 1] = A[i];
                i --;
            }
        }
        while (j >= 0) {
            A[j] = B[j];
            j --;
        }
    }
}
