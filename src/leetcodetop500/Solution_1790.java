package leetcodetop500;

import jdk.nashorn.internal.ir.IfNode;
import sun.nio.cs.FastCharsetProvider;

/**
 * @author: xuejing
 * @date: 2021/03/17 10:37
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 */
public class Solution_1790 {

    // 需要考虑以下几种情况：
    // 1.两个字符串的长度不相等，直接返回 false
    // 2.两个字符串完全相同，直接返回 true
    // 3.两个字符串不相同，找出两个字符不同的下标，如果字符不同的个数大于2，说明不可能，直接返回 false
    // 若字符不同的个数等于2，则需判断交换后是否相同
    public boolean areAlmostEqual(String s1, String s2) {
        // base case
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int first = -1;
        int second = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                }else {
                    // 说明字符不同的个数大于2，直接返回 false
                    return false;
                }
            }
        }
        return second != -1 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }
}
