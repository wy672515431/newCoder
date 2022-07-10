package 面试;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
        private List<List<String>> ans = new ArrayList();
        private List<String> tem = new ArrayList();
        public List<List<String>> partition(String s) {
                int length = s.length();
                boolean[][] dp = new boolean[length][length];
                for(int i=length-1;i>=0;i--){
                        dp[i][i] = true;
                        for(int j=i+1;j<length;j++){
                                if(s.charAt(i) == s.charAt(j)){
                                        if(j - i == 1)
                                                dp[i][j] = true;
                                        else
                                                dp[i][j] = dp[i+1][j-1];
                                }
                        }
                }
                solve(dp,s,length,0);
                return ans;
        }
        public void solve(boolean[][] dp,String s,int length,int start){
                for(int i = 0;i + start < length;i++){
                        if(!dp[start][i+start]){
                                //tem.remove(tem.size()-1);
                                continue;
                        }
                        else{
                                tem.add(s.substring(start,i+start+1));
                                if(i+start+1 == length){
                                        ans.add(new ArrayList(tem));
                                }else
                                        solve(dp,s,length,start+i+1);
                                tem.remove(tem.size()-1);
                        }
                }
        }

        public static void main(String[] args) {
                new 分割回文串().partition("efe");
        }
}
