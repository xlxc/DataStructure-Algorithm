package leetcodetop300;

/**
 * @author: xuejing
 * @date: 2021/02/04 9:38
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 */
public class Solution1004 {

    /**
     * 这题可以使用滑动窗口，滑动窗口的题目可以分为两种：1）窗口长度固定；2）窗口长度不固定
     * 窗口长度固定的题目比较简单，实现也简单;  使用双指针即可
     * 窗口长度不固定的题目比较难，主要是要判断何时进行窗口的左右两侧的移动，这样根据题目的要求来计算
     * @param a
     * @param k
     * @return
     */
    public int longestOnes(int[] a, int k) {
        if (a == null || a.length == 0) {
            return 0;
        }
        // 这道题是窗口长度不固定的类型
        // 如果当前窗口内通过 k 次变化可以实现全部为1，则我们可以继续寻找最长的右侧窗口，这时右侧窗口移动
        // 如果当前窗口内不能通过 k 次变化实现全部为1，则就算移动右侧窗口，肯定是不可能实现全1的，此时需要将左侧窗口移动
        int left = 0;
        int right = 0;
        int res = 0;
        int countOne = 0;
        while (right < a.length) {
            countOne += a[right] == 1 ? 1 : 0;
            right++;
            // 对于 left~right 的区间，窗口的长度为 right - left + 1，由于前面已经加了1，所以这里是 right -left
            // 当1的个数与k的和小于窗口的长度时，这是就不满足了，需要移动左侧窗口
            if (right - left > countOne + k ) {
                // 移动左侧窗口的时候，需要判断左侧的值是否是1，若是1，需要将 countOne -1
                countOne -= a[left] == 1 ? 1 : 0;
                left++;
            } else {
                res++;
            }
        }
        return res;
    }
}
