package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2021/03/02 8:59
 * 304. 二维区域和检索 - 矩阵不可变
 */
public class Solution_304 {

    // 方法一：使用一维数组前缀和，提前求出每一行数组的一维前缀和
    // 结果就是n行数组前缀和的和，查询一行的子数组的时间是O(1)，那么查询n行的子矩阵，时间复杂度就是O(n)
    //    static class NumMatrix {
    //        int[][] sum;
    //        public NumMatrix(int[][] matrix) {
    //            // base case
    //            if (matrix == null || matrix.length == 0) {
    //                return;
    //            }
    //            int rows = matrix.length;
    //            int cols = matrix[0].length;
    //            sum = new int[rows][cols+1];
    //            for (int i = 0; i < rows; i++) {
    //                for (int j = 0; j < cols; j++) {
    //                    sum[i][j+1] = sum[i][j] + matrix[i][j];
    //                }
    //            }
    //        }
    //
    //        public int sumRegion(int row1, int col1, int row2, int col2) {
    //            int res = 0;
    //            // 将每一行的子数组的前缀和相加即可
    //            for (int i = row1; i <= row2; i++) {
    //                res += sum[i][col2+1] - sum[i][col1];
    //            }
    //            return res;
    //        }
    //    }

    /* 方法二：上述的方法一的时间复杂度是O(n)， 如何将时间复杂度降为O(1)呢？*/
    // 我们定义，preSum[i][j]的前缀和表示从矩阵中(0,0)到(i,j)的所有元素之和
    // 那么前缀和

    static class NumMatrix {
        int[][] preSum;

        public NumMatrix(int[][] matrix) {
            // base case
            if (matrix == null || matrix.length == 0) {
                return;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            preSum = new int[rows + 1][cols + 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 将每一行的子数组的前缀和相加即可
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        }
    }

}
