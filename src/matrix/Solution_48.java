package matrix;

/**
 * @author: xuejing
 * @date: 2020/12/19 9:40
 * 48.旋转图形
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_48 {

    // 对于矩阵类问题，我们都可以考虑转圈来解决
    // 先处理外围一圈，然后在处理里面的一圈

    public void rotate(int[][] matrix) {
        // base case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // 一圈一圈的遍历，需要左上角和右下角的坐标位置
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        // 总的组数
        int times = dC - tC;
        int temp = 0;
        for (int i = 0; i < times; i++) {
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = temp;
        }
    }

    public static void main(String[] args) {

    }

}
