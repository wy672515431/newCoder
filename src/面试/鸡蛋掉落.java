package 面试;

import java.util.HashMap;

public class 鸡蛋掉落 {
    /***
     * 我们考虑动态规划
     * 状态为(k,n)表示k个鸡蛋,n层楼。
     * 假设现在在第x层楼，如果扔下去鸡蛋没有碎，那么状态变为(k, n - x)
     * 如果鸡蛋碎了,那么状态变为(k - 1, x - 1)
     * 所以(k, n) = 1 + Min(Max((k, n - x), (k - 1, x- 1))) x from 1 to n
     * 显然一共有kn个状态，对于每个状态需要遍历x,复杂度为Kn^2.
     * 我们观察到(k, n)是一个关于n的单调函数，在上述的转移方程中,第一个为关于x的递减函数，第二个是关于x的递增函数。
     * 如何找到二者的最小值？如果它们为连续函数，那么交点即为最小值。但是为离散函数、所对应的即为离交点最近的整数点
     * 我们对x进行二分查找。如果(k, n - x) > (k - 1 , x - 1) 则Mid在x的右边
     * 若(k , n - x) < (k - 1, x - 1)则Mid在x的左边
     *
     * @param k 鸡蛋个数
     * @param n 楼层数
     * @return
     */
    //来存储状态
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    public int dp(int k, int n) {
        if (!map.containsKey(n * 100 + k)) {
            int ans = 0;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int low = 1;
                int high = n;
                int mid;
                while (low + 1 < high) {
                    mid = (low + high) >> 1;
                    int tem1 = dp(k, n - mid);
                    int tem2 = dp(k - 1, mid - 1);
                    if (tem1 > tem2) {
                        low = mid;
                    } else if (tem1 < tem2) {
                        high = mid;
                    } else {
                        low = high = mid;
                    }
                }
                ans = 1 + Math.min(Math.max(dp(k, n - low), dp(k - 1, low - 1)), Math.max(dp(k, n - high), dp(k - 1, high - 1)));
            }
            map.put(n * 100 + k, ans);
        }
        return map.get(n * 100 + k);
    }
}
