package 面试;

public class 解码方式 {
    /***
     * dp[i]代表0~i-1字符串的解码方式,dp[0] = 0
     * dp[1]
     * dp[2]
     * * 与最后一个字母有关
     * 最后一个不为0
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                dp[i + 1] = (s.charAt(i) == '0') ? 0 : 1;
            } else {
                if (s.charAt(i - 1) == '0' && s.charAt(i) == '0')
                    dp[i + 1] = 0;
                else if (s.charAt(i - 1) == '0' && s.charAt(i) != '0')
                    dp[i + 1] += dp[i];
                else if (s.charAt(i - 1) != '0' && s.charAt(i) == '0') {
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                        dp[i + 1] += dp[i - 1];
                    } else
                        dp[i + 1] = 0;
                } else {
                    dp[i + 1] += dp[i];
                    int num = Integer.parseInt(s.substring(i - 1, i + 1));
                    if (num >= 1 && num <= 26)
                        dp[i + 1] += dp[i - 1];
                }
            }
        }

        return dp[s.length()];
    }

}
