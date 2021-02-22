package slidingWindow;

/**
 * @author: xuejing
 * @date: 2021/02/04 10:27
 * 424.替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 */
public class Solution_424 {

    // 这道题要求的是最长的子串的长度，对于连续问题的最值，可以考虑使用滑动窗口
    // 这道题和上一题最大连续1的个数有点类似，只不过这道题目中的1的个数变成了窗口内出现次数最多的字符
    // 边界条件是什么呢？
    // 当
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;



        return 0;

    }
}
