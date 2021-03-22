package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2021/03/21 9:47
 */
public class Solution_73 {

    // 遍历两次数组，使用两个一维数组分别表示需要变换成0 的下标
    // 第一次遍历，根据下标的值来找出需要变换的位置，第一遍历，进行置0
    public void setZeroes(int[][] matrix) {
        // base case
        if (matrix == null || matrix.length == 0) {
            return;
        }
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        // 置0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
