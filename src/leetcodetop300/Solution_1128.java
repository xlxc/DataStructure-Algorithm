package leetcodetop300;

import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * @author: xuejing
 * @date: 2021/01/26 9:04
 * 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1128 {

    // 本题的要求就是找到二元组相同元素的个数，我们可以使用哈希表来解决
    // 根据题目的要求，需要先对每一对二元组进行排序，然后转换成成两位数字
    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0) {
            return 0;
        }
        // 由于组成的是两位数，所以我们可以使用长度为100的数组来作为哈希表
        int[] map = new int[100];
        int res = 0;
        for (int[] dominoe : dominoes) {
            Arrays.sort(dominoe);
            int num = dominoe[0] * 10 + dominoe[1];
            res += map[num]++;
        }
        return res;
    }
}






















