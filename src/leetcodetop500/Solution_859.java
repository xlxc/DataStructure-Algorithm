package leetcodetop500;

import java.util.Arrays;

/**
 * @author: xuejing
 * @date: 2021/03/16 22:45
 */
public class Solution_859 {

    // 有以下几种情况：
    // 1、字符串长度不相等，直接返回 false
    // 2、字符串相等，若有重复元素，则返回 true
    // 3、字符串不相同，若有两个不相等的字符，需要查看交换后是否相等
    public boolean buddyStrings(String a, String b) {
        // base case
        if (a == null || b == null) {
            return false;
        }
        // 情况1：字符串长度不相等
        if (a.length() != b.length()) {
            return false;
        }
        // 情况2：字符串相同，若有重复元素，则返回true，否则返回false
        if (a.equals(b)) {
            // 小写字母组成，使用数组判重
            char[] set = new char[26];
            for (char c : a.toCharArray()) {
                set[c - 'a']++;
                if (set[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
        // 情况3：字符串不相同，若有两个不相等的字符，需要查看交换后是否相等
        int first = -1;
        int second = -1;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    // 此时，说明有多于2处的地方，字符不相同
                    return false;
                }
            }
        }
        // 上面找出了两个不同的字符的地方，现在要判断这两个字符是够相同
        return second != -1 && a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first);
    }
}
