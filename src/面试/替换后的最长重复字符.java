package 面试;

import java.util.concurrent.ConcurrentHashMap;

/***
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度.
 */
public class 替换后的最长重复字符 {
        public int characterReplacement(String s, int k) {
                int left = 0;
                int right = 0;
                int charMax = 0;
                int[] nums = new int[26];
                while(right < s.length()){
                        nums[s.charAt(right) -'A']++;
                        charMax = Math.max(charMax,nums[s.charAt(right)-'A']);
                        if(right - left + 1 - charMax > k){
                                nums[s.charAt(left) - 'A'] --;
                                left++;
                        }
                        right++;
                }
                return right-left;
        }

        public static void main(String[] args) {

        }
}
