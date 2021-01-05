package leetcodetop300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2021/01/05 9:00
 */
public class Solution_830 {

    // 该题考查以下几点：
    // 获得连续的串的起止和终止下标
    // 本题使用双指针进行查找连续的元素
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int end = 1;
        // ----这里的代码还可以进行优化---
        s += "*";
        while (end < s.length()) {
            // 若二者相等，则end指针后移一位
            if (s.charAt(start) == s.charAt(end)) {
                end++;
            } else {
                // 若不相等，那么，start就变成 end，同时看二者的间距是否大于等于3，
                // 若二者间距大于等于3就要加入结果中
                if (end - start >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end - 1);
                    res.add(list);
                }
                start = end;
                end++;
            }
        }
        // -------
        return res;
    }

    public static void main(String[] args) {
        Solution_830 sol = new Solution_830();
        System.out.println(sol.largeGroupPositions("aaa"));
    }

}
