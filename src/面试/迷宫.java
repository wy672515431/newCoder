package 面试;

public class 迷宫 {
        private boolean flag = false;
        private int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        private boolean[][] isVisited;
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
                int n = maze.length;
                int m = maze[0].length;
                isVisited = new boolean[n][m];
                dfs(maze,start[0],start[1],n,m,destination[0],destination[1]);
                return flag;
        }
        private void dfs(int[][] maze,int i,int j,int n,int m,int di,int dj){
                if(i == di && j==dj){
                        flag = true;
                }
                isVisited[i][j] = true;
                for(int k=0;k<4;k++){
                        int newi = i+dir[k][0];
                        int newj = j+dir[k][1];
                        if(newi<0||newi>=n||newj<0||newj>=m||isVisited[newi][newj]||maze[newi][newj] == 1)
                                continue;
                        dfs(maze,newi,newj,n,m,di,dj);
                        if(flag)
                                break;
                }
                isVisited[i][j] = false;
        }
}
