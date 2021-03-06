package leetcodetop500;

import java.util.List;

/**
 * @author: xuejing
 * @date: 2021/03/03 15:59
 */
public class Solution_131 {

    // 暴力的方法就是列举出字符串的每个子集，同时验证子集中的每个元素是否都是回文
    // 对于暴力的枚举，可以画出递归树，同时可以在枚举的过程中验证是否是回文，所以可以使用回溯法
    //
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        return null;
    }

    private void dfs () {

    }
}
