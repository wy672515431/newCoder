package 题目;

public class N皇后问题 {
        private boolean[][] isVisited = new boolean[3][40];
        private int ans = 0;
        public void solve(int cur,int n){
                if(cur == n){
                        ans++;
                        return;
                }
                for(int i=0;i<n;i++){
                        //0代表同一行上没有
                        if(!isVisited[0][i]&&!isVisited[1][i+cur]&&!isVisited[2][cur-i+n]){
                                isVisited[0][i] = true;
                                isVisited[1][i+cur] = true;
                                isVisited[2][cur-i+n] = true;
                                solve(cur+1,n);
                                isVisited[0][i] = false;
                                isVisited[1][i+cur] = false;
                                isVisited[2][cur-i+n] = false;
                        }
                }
        }
}
