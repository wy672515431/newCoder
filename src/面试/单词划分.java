package 面试;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词划分 {

    /***
     * 动态规划
     * dp[i]代表字符串前i个字符是否能够被拆分 即s[0~i-1]是否能被划分。
     * 每次转移的时候我们需要枚举包含位置 i-1 的最后一个单词，看它是否出现在字典中以及除去这部分的字符串是否合法即可.
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        //空串默认为true
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }


}
