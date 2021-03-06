package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2021/02/22 11:58
 * 766. 托普利茨矩阵
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 */
public class Solution_766 {

    // 根据定义，当且仅当矩阵中每个元素都与其左上角相邻的元素（如果存在）相等时，该矩阵为托普利茨矩阵。
    // 因此，我们遍历该矩阵，将每一个元素和它左上角的元素相比对即可。。
    public boolean isToeplitzMatrix(int[][] matrix) {
        // base case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 列记录要到前面一个
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
