package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/11/27 11:07
 */
public class Solution_784 {

    public static void main(String[] args) {
        Solution_784 solution_784 = new Solution_784();
        String str = "a1b2";
        System.out.println(solution_784.letterCasePermutation(str).toString());
    }

    public List<String> letterCasePermutation(String str) {
        List<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        dfs(chs, 0, res);
        return res;
    }

    private void dfs(char[] chs, int index, List<String> res) {
        if (index == chs.length) {
            res.add(new String(chs));
            return;
        }
        // 如果是字母，则有两种选择：
        //   1) 变成大写形式，然后继续递归；
        //   2) 变成小写形式，然后继续递归。
        // 变成小写形式，继续递归
        // 如果是数字，直接加入路径中
        dfs(chs, index + 1, res);
        if (Character.isLetter(chs[index])) {
            // 大小写转换
            chs[index] ^= 1 << 5;
            dfs(chs, index + 1, res);
        }
    }

}
