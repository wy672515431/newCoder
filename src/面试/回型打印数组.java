package 面试;

public class 回型打印数组 {
        /***
         *
         * @param n n为二维数组的行数
         * @param m m为二维数组的列数
         * @return
         */
        public int[][] solve(int n,int m){
                int[][] ans = new int[n][m];
                int top = 0;
                int bottom = n-1;
                int left = 0;
                int right = m-1;
                int i = 0;
                int j = 0;
                int cnt = 0;
                while(top<=bottom&&left<=right){
                        if(i == top && j == left){
                                while (j!=right){
                                        ans[i][j] = cnt++;
                                        j++;
                                }
                                ans[i][j] = cnt++;
                                top++;
                                i++;
                        }
                        else if(i == top && j == right){
                                while (i!=bottom){
                                        ans[i][j] = cnt++;
                                        i++;
                                }
                                ans[i][j] = cnt++;
                                right --;
                                j--;
                        }
                        else if(i == bottom && j == right){
                                while (j!=left){
                                        ans[i][j] = cnt++;
                                        j--;
                                }
                                ans[i][j] = cnt++;
                                bottom--;
                                i--;
                        }else if(i == bottom && j == left){
                                while (i!=top){
                                        ans[i][j] = cnt++;
                                        i--;
                                }
                                ans[i][j] = cnt++;
                                left++;
                                j++;
                        }
                }
                return ans;
        }

        public static void main(String[] args) {
                int[][] tem = new 回型打印数组().solve(4,4);
                for(int i=0;i<4;i++){
                        for(int j=0;j<4;j++){
                                System.out.print(tem[i][j]+" ");
                        }
                        System.out.println();
                }
        }
}
