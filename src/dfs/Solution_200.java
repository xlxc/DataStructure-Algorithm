package dfs;

import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.javafx.scene.control.ReadOnlyUnbackedObservableList;
import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * @author: xuejing
 * @date: 2020/11/28 22:00
 * 200.岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Solution_200 {

    // 本题的解题思路是：遍历矩阵中的每个元素，当遇到0，就什么都不做，继续遍历下一个
    // 当遇到 1 时，就使用 dfs，向上、下、左、右四个方向进行遍历，若是 1，就将其置为0，然后继续dfs
    private int result = 0;

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 遍历矩阵
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, i, j);
                result++;
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        // base case ：边界判断
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        // 如果遇到了0 ，也直接返回
        if (grid[i][j] == '0') {
            return;
        }
        // 否则就是1，将 1变成 0
        grid[i][j] = '0';
        // 继续使用dfs 向 上、下、左、右四个方向进行搜索
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }

}
