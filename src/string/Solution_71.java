package string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * @author: xuejing
 * @date: 2020/12/19 10:15
 * 71. 简化路径
 */
public class Solution_71 {

    // 由题意可知，题目要求得到是一个绝对路径的地址，转换后的结果不能包含 .. 和 .
    // 所以我们可以借助于栈，当遇到 .. 就从栈中弹出一个元素即可
    public String simplifyPath(String path) {
        // base case
        if (path == null || path.length() == 0) {
            return path;
        }
        // 首先对字符串进行预处理，
        path = path.substring(1, path.length());
        String[] strs = path.split("/+");
        Deque<String> stack = new ArrayDeque<>();
        for (String str:strs){
            if (".".equals(str) || "".equals(str)) {
                continue;
            } else if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pollFirst();
                }
            } else {
                stack.addFirst(str);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append("/"+stack.pollLast());
        }
        return "".equals(stringBuilder.toString()) ? "/" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution_71 sol = new Solution_71();
        String path = "///TJbrd/owxdG//";
        System.out.println(sol.simplifyPath(path));
    }
}
