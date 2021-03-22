package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2021/03/22 8:53
 * 419. 甲板上的战舰
 */
public class Solution_419 {

    // 根据题目要求，两艘战舰之间必须要有一个空位间隔，
    // 方法一：依次遍历矩阵中的每个数，若当前数的上面一个并且右边一个都是空的，说明这是一艘战绩，否则就不是
    public int countBattleships(char[][] board) {
        // base case
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j] == 'X') && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    ++count;
                }
            }
        }
        return count;
    }
}
