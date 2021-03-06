package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2020/12/15 9:08
 * 738.单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_738 {

    // 题目要求给定一个数字，找出小于等于这个数字，同时要求找出的这个数每个位上的数都是单调递增的
    // 思路：从右到左遍历整个数字，若当前数字比其左边的数字（高位）小，
    // 则将左边的数字减一，同时该位及其右边的所有数字都变成9
    public int monotoneIncreasingDigits(int n) {
        if (n <= 0) {
            return n;
        }
        String s = String.valueOf(n);
        int len = s.length();
        char[] chars = s.toCharArray();
        int flags = len;
        // 从右向左遍历
        for (int i = len-1; i > 0; i--) {
            if (chars[i] < chars[i-1]) {
                flags = i;
                chars[i-1]--;
            }
        }
        // 由于要变9是将后面的所有数字都变成9，所以可以使用一个变量记录最左边的值，然后最后统一变成9即可
        for (int i = flags; i < len; i++){
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        Solution_738 sol = new Solution_738();
        System.out.println(sol.monotoneIncreasingDigits(1234));
    }
}
