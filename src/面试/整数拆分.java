package 面试;

public class 整数拆分 {
        private static int[][] dp;
        //整数n的m划分

        /***
         * 当n=1,无论m多少，只有一种划分
         * 当m-1，无论n多少，只有一种划分
         * 当n=m时，划分中包含n，只有一种划分。dp[n][n] = dp[n][n-1]+1
         *当n<m时，f[n][m] = f[n][n]
         * 当n>m时，如果包含m f[n][m] = f[n-m][m]，如果不包含f[n][m] = f[n][m-1]
         * 则f[n][m] = f[n-m][m] + f[n][m-1]
         * @param n
         * @param m
         * @return
         */
        public static int solve(int n,int m){
                dp = new int[n+1][m+1];
                for(int i=1;i<=n;i++){
                        for(int j=1;j<=i;j++){
                                if(i==1 || j==1)
                                        dp[i][j] = 1;
                                else{
                                        if(j == i)
                                                dp[i][j] = 1+dp[i][j-1];
                                        else if((i-j)<j)
                                                dp[i][j] = dp[i-j][i-j]+dp[i][j-1];
                                        else
                                                dp[i][j] = dp[i-j][j]+dp[i][j-1];
                                }
                        }
                }
                return dp[n][m];
        }

        public static void main(String[] args) {
                System.out.println(solve(10,10));
        }
}
