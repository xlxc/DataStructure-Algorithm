package meituan;

/**
 * @author: xuejing
 * @date: 2020/12/25 23:11
 * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次有一些翻转操作，要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
 * 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
 * 测试样例：
 */
public class MT2_flipChess {

    // 题目的大致意思是：给定一个 4*4 大小的棋盘(注意；题目要求下标是从1开始的)
    // 棋盘中的0/1 分别代表 黑、白颜色
    // 然后给定一系列坐标，要求将给定坐标周围的棋子(上下左右四个方向)的颜色变成相反(即黑变白，白变黑)
    // 这题不难，考查的是对数组的操作能力，以及边界情况的考虑
    public int[][] flipChess(int[][] A, int[][] f) {
        // base case
        int rows = A.length;
        int cols = A[0].length;
        if (rows == 0 || cols == 0) {
            return A;
        }
        // 我们直接在原数组上进行操作即可
        // 由于是将 0变1,1变0，我们可以使用异或操作（与1异或即可）
        for (int i = 0; i < f.length; i++) {
            // 注意：这里要减1，SB输入要求
            changeColor(A, f[i][0] - 1, f[i][1] - 1);
        }
        return A;
    }

    private void changeColor(int[][] A, int i, int j) {
        // base case
        int rows = A.length;
        int cols = A[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }
        // 上
        if (i - 1 >= 0) {
            A[i - 1][j] = A[i - 1][j] ^ 1;
        }
        // 下
        if (i + 1 < rows) {
            A[i + 1][j] = A[i + 1][j] ^ 1;
        }
        // 左
        if (j - 1 >= 0) {
            A[i][j - 1] = A[i][j - 1] ^ 1;
        }
        // 右
        if (j + 1 < cols) {
            A[i][j + 1] = A[i][j + 1] ^ 1;
        }
    }

}
