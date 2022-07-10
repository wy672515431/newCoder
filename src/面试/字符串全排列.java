package 面试;

import java.util.ArrayList;

public class 字符串全排列 {
        /***
         * 可能有重复字母
         */
        private int[] cnt = new int[26];
        private ArrayList<String> list = new ArrayList();
        private StringBuffer sb = new StringBuffer();
        public String[] permutation(String s) {
                for(int i=0;i<s.length();i++)
                        cnt[s.charAt(i)-'a']++;
                solve(s);
                String[] ans = (String[])list.toArray(new String[list.size()]);
                return ans;
        }
        public void solve(String s){
                for(int i=0;i<26;i++){
                        if(cnt[i] == 0)
                                continue;
                        cnt[i] --;
                        char ch = (char)(i+'a');
                        sb.append(ch);
                        if(sb.length() == s.length())
                                list.add(sb.toString());
                        else{
                                solve(s);
                        }
                        sb.deleteCharAt(sb.length()-1);
                        cnt[i]++;
                }
        }
}
