package across_the_year;

import javafx.util.Pair;
import leetcodetop300.Solution_830;

/**
 * @author: xuejing
 * @date: 2021/01/17 10:30
 * 1232. 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1232 {

    // 首先使用两个点来确定一个直线方程，然后将其他的点代入直线方程即可知道是不是这个方程
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) {
            return true;
        }
        double[] kb = getFum(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        for (int i = 2; i < coordinates.length; i++) {
            if (!isFum(kb[0], kb[1], coordinates[i][0], coordinates[i][1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据两个点来确定一个方程
     */
    private double[] getFum(int x1, int y1, int x2, int y2) {
        double[] res = new double[2];
        res[0] = (y2 - y1) * 1.0 / (x2 - x1);
        res[1] = y1 - res[0] * x1;
        return res;
    }

    /**
     * 对于一个一次方程 y=kx+b,我们只需要确定 k 和 b，就知道了方程的表达式
     *
     * @return
     */
    private boolean isFum(double k, double b, int x, int y) {
        double tempY = k * x + b;
        return tempY == y;
    }

    public static void main(String[] args) {
        Solution_1232 sol = new Solution_1232();
        int[][] a = {{0,0}, {0, 1}, {0, -1}};
        sol.checkStraightLine(a);

    }
}
