package leetcodetop300;

/**
 * @author: xuejing
 * @date: 2021/03/03 9:10
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class Solution_79 {

    private boolean[][] visited;

    // 此题是典型的二维数组中的dfs问题，由于题目要求每个位置上的单词不能重复使用，所以需要用一个数组来记录是否访问过
    // 没遇到一次单词，就开始进行dfs搜索
    public boolean exist(char[][] board, String word) {
        // base case
        if (board == null || board.length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int index) {
        // base case
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        // 这里要注意，搜索完之后需要将
        boolean res =  search(board, i - 1, j, word, index + 1) || search(board, i + 1, j, word, index + 1) || search(board, i,
            j + 1, word, index + 1) || search(board, i, j - 1, word, index + 1);

        visited[i][j] = false;
        return res;

    }

    public static void main(String[] args) {
        Solution_79 sol = new Solution_79();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String a = "ABCCED";
        System.out.println(sol.exist(board, a));
    }
}
