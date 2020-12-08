package backtracking;

/**
 * @author: xuejing
 * @date: 2020/12/02 17:32
 * 剑指Offer 12: 矩阵中的路径
 */
public class Offer_12 {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] used = new boolean[board.length + 1][board[0].length + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 如果当前的字符是第一个 那么就直接从 上下左右进行遍历
                if (dfs(board, word, i, j, 0, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board
     * @param word
     * @param i
     * @param j
     * @param index: 字符串中的位置
     * @return
     */
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] used) {
        // 当矩阵的下标越界或者当前字符不匹配，直接返回 false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index) || used[i][j]) {
            return false;
        }
        // 当 index 到达了 最后，说明是匹配的
        if (index == word.length() - 1) {
            return true;
        }
        used[i][j] = true;
        boolean res =
            dfs(board, word, i - 1, j, index + 1, used) || dfs(board, word, i + 1, j, index + 1, used) || dfs(board,
                word, i, j - 1, index + 1, used) || dfs(board, word, i, j + 1, index + 1, used);
        used[i][j] = false;
        return res;

    }

}
