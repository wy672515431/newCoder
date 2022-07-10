package 面试;

public class 搜索二维矩阵 {
        /***
         * 方法一时间复杂度O(m+n)
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix(int[][] matrix, int target){
                if(matrix.length == 0)
                        return false;
                int n = matrix.length;
                int m = matrix[0].length;
                int i = 0;
                int j = m-1;
                while (i<n&&j>=0){
                        if(matrix[i][j] == target)
                                return  true;
                        else if(matrix[i][j] < target)
                                i++;
                        else
                                j--;
                }
                return false;
        }

        /***
         * 时间复杂度O(log(mn))
         * 我们将这个二维数组看作一个一维数组，其是单调不递减的。
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix1(int[][] matrix, int target){
                int n = matrix.length;
                int m = matrix[0].length;
                int low = 0;
                int high = n*m-1;
                int mid;
                while (low<=high){
                        mid = low+(high-low)/2;
                        if(matrix[mid/m][mid%m] == target)
                                return true;
                        else if(matrix[mid/m][mid%m] < target)
                                low = mid+1;
                        else
                                high = mid-1;
                }
                return false;
        }
}
