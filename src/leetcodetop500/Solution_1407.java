package leetcodetop500;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: xuejing
 * @date: 2021/03/09 8:59
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class Solution_1407 {

    // 注意看清题目：题目要求的是每次删除都是删除相邻两个，相邻的三个及其以上的则不考虑
    // 故本题可以使用栈来解决
    public String removeDuplicates(String s) {
        // base case
        if (s == null || s.trim().length() == 0) {
            return s;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && chars[i] == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
