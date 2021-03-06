package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2021/02/25 8:42
 * 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 */
public class Solution_867 {

    // 所谓的转置就是把第一行变成第一列，第二行变成第二列
    public int[][] transpose(int[][] matrix) {
        // base case
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        // 转置后原来的行、列的个数就发生了变化，
        int rows = matrix[0].length;
        int cols = matrix.length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
