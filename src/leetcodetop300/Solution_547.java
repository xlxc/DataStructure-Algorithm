package leetcodetop300;

/**
 * @author: xuejing
 * @date: 2021/01/07 12:25
 */
public class Solution_547 {

    /**
     * 可以看成是图，城市是图中的节点，相连关系就是图中的边，给定的矩阵isConnected 即为图的邻接矩阵，所要求的省份就是图中的连通分量
     * 所以我们可以使用深度优先搜索进行图的遍历，
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }
        int res = 0;
        // n 为无向图的顶点个数
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 若当前顶点n未被访问，说明是一个新的连通域
            if (!isVisited[i]) {
                dfs(isConnected, isVisited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, boolean[] isVisited, int i) {
        isVisited[i] = true;
        // 继续遍历与顶点 i 相邻的顶点
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                dfs(isConnected, isVisited, j);
            }
        }
    }

}
