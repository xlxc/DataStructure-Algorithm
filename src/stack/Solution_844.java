package stack;

import javafx.css.StyleableStringProperty;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: xuejing
 * @date: 2020/12/26 16:42
 * 844.比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_844 {

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    // 将字符串中的 # 去掉，可以借助于栈
    // 将元素进栈，当遇到 # 就从栈中删除一个元素
    private String build(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution_844 sol = new Solution_844();
        System.out.println(sol.build("y#fo##f"));
        System.out.println(sol.build("y#f#o##f"));
    }
}
