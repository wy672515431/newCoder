package 面试;

import java.util.HashMap;

public class 至多包含k个不同字符的最长子串 {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
                HashMap<Character,Integer> map = new HashMap();
                int ans = 0;
                int left = 0;
                int i=0;
                for(i=0;i<s.length();i++){
                        if(map.get(s.charAt(i)) == null)
                                map.put(s.charAt(i),1);
                        else
                                map.put(s.charAt(i),map.get(s.charAt(i))+1);
                        if(map.size()>k){
                                ans = Math.max(ans,i-left);
                                int j;
                                for(j=left;j<i;j++){
                                        map.put(s.charAt(j),map.get(s.charAt(j))-1);
                                        if(map.get(s.charAt(j)) == 0){
                                                map.remove(s.charAt(j));
                                        }
                                        left = j+1;
                                        break;
                                }
                                left = j+1;
                        }
                }
                ans = Math.max(ans,i-left);
                return ans;
        }
}
