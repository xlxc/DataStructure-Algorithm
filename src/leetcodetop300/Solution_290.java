package leetcodetop300;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2020/12/16 9:04
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_290 {

    // 这一题与 205.同构字符串 有点相似
    // 直接使用 Map 即可
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        // 专门存储 value 是否出现过
        Set<String> set = new HashSet<>();
        char[] patterns = pattern.toCharArray();
        String[] strs = s.split("\\s");
        if (patterns.length != strs.length) {
            return false;
        }
        int i =0;
        for (i = 0; i < patterns.length; i++) {
            if (map.containsKey(patterns[i])) {
                if (!map.get(patterns[i]).equals(strs[i])) {
                    return false;
                }
            } else {
                if (set.contains(strs[i])) {
                    return false;
                }
                set.add(strs[i]);
                map.put(patterns[i],strs[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_290 sol = new Solution_290();
        String pattern  = "jquery";
        String str = "jquery";
        System.out.println(sol.wordPattern(pattern,str));
    }
}
