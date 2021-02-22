package slidingWindow;

/**
 * @author: xuejing
 * @date: 2021/02/05 8:48
 * 1208. 尽可能使字符串相等
 */
public class Solution_1208 {

    // 题目要求的可以转换的最大子串的长度，对于子串的连续问题，可以使用滑动窗口
    // 首先可以求出两个字符串对应位置转换需要的代价，最后问题抓换成求数组中连续和不超过 maxCost，且使窗口长度最大的值
    public int equalSubstring(String s, String t, int maxCost) {
        if (s == null || t == null || s.length() != t.length()) {
            return 0;
        }
        int[] costs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        // 对于一个不定长的滑动窗口问题，我们要明白一个道理：当遇到长度为 l 的滑动窗口不满足题意的限制条件时，
        // 此时滑动窗口右侧移动肯定是更加不会满足要求的，此时就需要将窗口长度缩小，将窗口左侧进行移动，
        // 这里的限制条件就是窗口的元素之和要小于 maxCost，
        int left = 0;
        int right = 0;
        int res = 0;
        int countCost = 0;
        while (right < costs.length) {
            countCost += costs[right];
            // 当窗口的代价和要大于maxCost时，就要不停地移动窗口左侧，直到不大于maxCost为止
            while (countCost > maxCost) {
                countCost -= costs[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_1208 sol = new Solution_1208();
        String s = "abcd";
        String t = "acde";
        int cost = 0;
        System.out.println(sol.equalSubstring(s, t, cost));
    }
}
