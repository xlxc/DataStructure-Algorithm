package backtracking;

/**
 * @author: xuejing
 * @date: 2020/11/28 18:20
 */
public class Solution_79 {

    public static void main(String[] args) {
        Solution_79 solution_79 = new Solution_79();
        char[][] borad = new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String  word = "ABCCED";
        System.out.println(solution_79.exist(borad,word));
    }

    public boolean exist(char[][] board, String word) {

        return false;
    }

}
