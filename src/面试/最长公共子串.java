package 面试;

public class 最长公共子串 {
        private int[][] dp;
        //  1 1 2
        //  1 1 3
        public String LCS (String str1, String str2) {
                // write code here
                int len1 = str1.length();
                int len2 = str2.length();
                int LCS_length=0;
                int LCS_location1=0;

                dp = new int[len1][len2];
                for(int i = 0 ;i<len1;i++){
                        for(int j =0;j<len2;j++){
                                if(str1.charAt(i) == str2.charAt(j)){
                                        if(i==0||j==0){
                                                dp[i][j] = 1;
                                        }else{
                                                dp[i][j] = dp[i-1][j-1]+1;
                                        }
                                        if(dp[i][j]>LCS_length){
                                                LCS_length = dp[i][j];
                                                LCS_location1 = i;

                                        }
                                }else{
                                        dp[i][j]=0;
                                }
                        }
                }
                StringBuffer sb = new StringBuffer();
                for(int i = 0;i<LCS_length;i++)
                        sb.append(str1.charAt(LCS_location1-i));
                sb.reverse();
                return sb.toString();
        }
}
