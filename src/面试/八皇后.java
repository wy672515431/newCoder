package 面试;

import java.util.Iterator;

public class 八皇后 {
        private boolean[][] isVisited;
        private int ans = 0;
        public int totalNQueens(int n) {
                isVisited = new boolean[3][40];
                solve(n,0);
                return ans;
        }
        public void solve(int n,int cur){
                if(cur == n){
                        ans++;
                        return;
                }
                for(int i=0;i<n;i++){
                        if(isVisited[0][i]||isVisited[1][i+cur]||isVisited[2][cur-i+n])
                                continue;
                        isVisited[0][i] = isVisited[1][i+cur] = isVisited[2][cur-i+n] = true;
                        solve(n,cur+1);
                        isVisited[0][i] = isVisited[1][i+cur] = isVisited[2][cur-i+n] = false;
                }
        }
        public static void main(String[] args) {

        }

}
