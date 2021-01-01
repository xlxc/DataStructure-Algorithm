package string;

import javax.security.auth.callback.CallbackHandler;

/**
 * @author: xuejing
 * @date: 2020/12/30 22:12
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class Solution_680 {

    // 暴力解法就是依次删除每个字符，判断剩下的字符是否是 回文串，显示会超出时间限制
    // 对于回文串题，我们就要使用头尾指针来解决，当头指针和尾指针指向的字符相等时，无需删除
    // 当二者指向的字符不等时，就要考虑删除 i 还是 j，那么为了删除后还是回文串
    // 若 [i+1,j] 或 [i,j-1] 有一个是回文串，那么即直接返回 true，说明可以达到题目要求

    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 3) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isHuiwen(s, left + 1, right) || isHuiwen(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isHuiwen(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
