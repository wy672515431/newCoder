package 面试;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 最长公共子序列 {
        class Node{
                int x;
                int y;
                int value;
                public Node(int x,int y,int value){
                        this.x = x;
                        this.y = y;
                        this.value = value;
                }
        }
        private int[][] dp;
        private StringBuffer sb = new StringBuffer();
        int maxLength = 0;
        private Stack<Node> stack = new Stack();
        public String LCS (String s1, String s2) {
                // write code here
                int len1 = s1.length();
                int len2 = s2.length();
                dp = new int[len1][len2];
                for(int i=0; i<len1; i++){
                        for(int j=0; j<len2 ;j++){
                                if(s1.charAt(i) == s2.charAt(j)){
                                        if(i==0||j==0){
                                                dp[i][j] = 1;
                                        }else
                                                dp[i][j] = dp[i-1][j-1]+1;
                                        stack.push(new Node(i,j,dp[i][j]));
                                        if(dp[i][j]>maxLength)
                                                maxLength = dp[i][j];
                                }else{
                                        if(i==0&&j==0)
                                                dp[i][j] = 0;
                                        else if(i==0)
                                                dp[i][j] = dp[i][j-1];
                                        else if(j==0)
                                                dp[i][j] = dp[i-1][j];
                                        else{
                                                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                                        }
                                }
                        }
                }
                int x = Integer.MAX_VALUE;
                int y = Integer.MAX_VALUE;
                while(!stack.isEmpty()){
                        Node tem = stack.peek();
                        if(tem.value == maxLength && tem.x<x && tem.y<y){
                                sb.append(s1.charAt(tem.x));
                                x = tem.x;
                                y = tem.y;
                                stack.pop();
                                maxLength--;
                        }else{
                                stack.pop();
                        }
                }
                if(sb.length() == 0)
                        return "-1";
                return sb.reverse().toString();
        }

        public static void main(String[] args) {
                Queue<Integer> queue = new LinkedList<>();

        }
}
