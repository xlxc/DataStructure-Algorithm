package leetcodetop500;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2021/03/03 15:59
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 */
public class Solution_131 {

    // 暴力的方法就是列举出字符串的每个子集，同时验证子集中的每个元素是否都是回文
    // 对于暴力的枚举，可以画出递归树，同时可以在枚举的过程中验证是否是回文，故可以使用回溯法
    //
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        Deque<String> stack = new ArrayDeque<>();
        char[] charArrays = s.toCharArray();
        dfs(charArrays, 0, stack, res);
        return res;
    }

    private void dfs(char[] charArrays, int index, Deque<String> path, List<List<String>> res) {
        // base case: 什么时候将路径加入结果集中
        if (index == charArrays.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < charArrays.length; i++) {
            // 判断当前截取的是否是回文串，如果不是，则直接进行下次截取，无需在进行dfs的
            if (!checkPalin(charArrays, index, i)) {
                continue;
            }
            path.addLast(new String(charArrays, index, i + 1 - index));
            dfs(charArrays, i + 1, path, res);
            path.removeLast();
        }
    }

    /**
     * 检查子串是否是回文串
     *
     * @return
     */
    private boolean checkPalin(char[] charArrays, int start, int end) {
        // 使用双指针检查
        while (start < end) {
            if (charArrays[start] != charArrays[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
