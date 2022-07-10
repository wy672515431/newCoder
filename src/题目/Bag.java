package 题目;

import java.util.HashMap;

public class Bag {
        private int[] dp;
        public int minMoney (int[] arr, int aim) {
                // write code here
                // 完全背包
                dp = new int[aim+1];
                dp[0] = 0;
                for(int i=1;i<=aim;i++)
                        dp[i] = Integer.MAX_VALUE-1;
                for(int i = 0;i<arr.length;i++){
                        for(int j=arr[i];j<=aim;j++)
                                dp[j] = Math.min(dp[j],dp[j-arr[i]]+1);
                }
                if(dp[aim] == Integer.MAX_VALUE-1)
                        return -1;
                else
                        return dp[aim];

        }

        public static void main(String[] args) {
                int[] a = {5,2,3};
                new Bag().minMoney(a,20);

        }
}
