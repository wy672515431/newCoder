package 面试;

public class 岛屿数量leetcode200 {
        private boolean[][] isVisited;
        private int ans = 0;
        private int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        public int numIslands(char[][] grid) {
                int m = grid.length;
                int n = grid[0].length;
                isVisited = new boolean[m][n];
                for(int i=0;i<m;i++){
                        for(int j=0;j<n;j++){
                                if(!isVisited[i][j]&&grid[i][j] == '1'){
                                        dfs(grid,i,j,m,n);
                                        ans++;
                                }
                        }
                }
                return ans;
        }
        public void dfs(char[][] grid,int i,int j,int m,int n){
                isVisited[i][j] = true;
                for(int k=0;k<4;k++){
                        int newi = i+dir[k][0];
                        int newj = j+dir[k][1];
                        if(newi<0||newi>=m||newj<0||newj>=n||isVisited[newi][newj]||grid[i][j] == '0')
                                continue;
                        dfs(grid,newi,newj,m,n);
                }
        }
}
