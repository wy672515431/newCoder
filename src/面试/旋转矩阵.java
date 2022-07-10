package 面试;

public class 旋转矩阵 {
        public void rotate(int[][] matrix) {
                int n = matrix.length;
                int top = 0;
                int bottom = n-1;
                int left = 0;
                int right = n-1;
                while(top<=bottom&&left<right){
                        for(int j=left;j<=right;j++){
                                int tem = matrix[j][n-1-top];
                                matrix[j][n-1-top] = matrix[top][j];
                                int tem1 = matrix[n-1-top][n-1-j];
                                matrix[n-1-top][n-1-j] = tem;
                                tem = matrix[n-1-j][top];
                                matrix[n-1-j][top] = tem1;
                                matrix[top][j] = tem;
                        }
                        top++;
                        left++;
                        right--;
                        bottom--;
                }
        }

        public static void main(String[] args) {
                int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
                new 旋转矩阵().rotate(matrix);
        }
}
