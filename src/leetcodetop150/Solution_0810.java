package leetcodetop150;

import com.sun.org.apache.xml.internal.utils.PrefixResolverDefault;

/**
 * @author: xuejing
 * @date: 2020/12/12 17:01
 * 颜色填充：
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * <p>
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
 * <p>
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * <p>
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/color-fill-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_0810 {
    // 很显然，此题使用深度优先搜索遍历即可
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int columns = image[0].length;
        if (rows == 0 || columns == 0 || sr >= rows || sc >= columns) {
            return image;
        }
        boolean[][] used = new boolean[rows][columns];
        dfs(image, sr, sc, image[sr][sc], newColor, used);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor, boolean[][] used) {
        // base case，越界了
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }
        // 如果当前的的颜色不是 oldColor，或者当前的路径已经被遍历过了，直接返回
        if (image[sr][sc] != oldColor || used[sr][sc]) {
            return;
        }
        // 如果是周围区域，就填充颜色
        used[sr][sc] = true;
        image[sr][sc] = newColor;
        // 向 上、下、左、右四个方向依次递归
        dfs(image, sr - 1, sc, oldColor, newColor, used);
        dfs(image, sr + 1, sc, oldColor, newColor, used);
        dfs(image, sr, sc - 1, oldColor, newColor, used);
        dfs(image, sr, sc + 1, oldColor, newColor, used);
    }

    public static void main(String[] args) {
        Solution_0810 sol = new Solution_0810();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] ans = sol.floodFill(image, sr, sc, newColor);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + ",");
            }
            System.out.println();
        }
    }

}














