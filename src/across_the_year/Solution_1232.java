package across_the_year;

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

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 3) {
            return true;
        }
        // 假设前两个点是固定的，先计算出前两个点的斜率，然后依次计算其余的点与第一个点所构成的斜率是否与这个相同即可
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];
            if ((y1 - y0) * (xi - x0) != (x1 - x0) * (yi - y0)) {
                return false;
            }
        }
        return true;
    }

}
