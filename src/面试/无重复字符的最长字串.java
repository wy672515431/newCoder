package 面试;

import java.util.HashMap;

public class 无重复字符的最长字串 {
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap();
        public int lengthOfLongestSubstring(String s) {
                int i = 0;
                int j = 0;
                for (; j < s.length(); j++) {
                        if (map.get(s.charAt(j)) == null) {
                                map.put(s.charAt(j), j);
                                ans = Math.max(ans, j - i + 1);
                        } else {
                                if (map.get(s.charAt(j)) < i) {
                                        map.put(s.charAt(j), j);
                                        ans = Math.max(ans, j - i + 1);
                                        continue;
                                }
                                i = map.get(s.charAt(j)) + 1;
                                //ans = Math.max(ans,j-i+1);
                                map.put(s.charAt(j), j);
                        }
                }
                return ans;
        }
}
