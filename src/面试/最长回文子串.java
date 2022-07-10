package 面试;

public class 最长回文子串 {
        private boolean[][] dp;
        public int getLongestPalindrome(String A, int n) {
                // write code here
                dp = new boolean[n][n];
                int ans=1;
                for(int i = n-1;i>=0;i--){
                        dp[i][i] = true;
                        for(int j =i+1;j<n;j++){
                                if(A.charAt(i) == A.charAt(j)){

                                        if(dp[i+1][j-1]&&j-i>1){
                                                dp[i][j] = true;
                                                ans = Math.max(ans,j-i+1);
                                        }else if(j-i==1){
                                                dp[i][j] = true;
                                                ans = Math.max(ans,j-i+1);
                                        }
                                }
                        }
                }
                return ans;
        }
}
