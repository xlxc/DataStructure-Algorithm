package 计算器问题;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: xuejing
 * @date: 2021/01/01 18:20
 */
public class Solution_772 {

    private int i = 0;
    public int calculate(String s) {
        s = s.trim();
        return core( s);
    }

    public int core(String s) {
        int num = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ')
                continue;
            if (ch == '(') {
                i++;
                num = core(s);
            }
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if (!Character.isDigit(ch) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:break;
                }
                sign = ch;
                num = 0;
            }
            if (ch == ')')
                break;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
    // 双栈实现

    public static void main(String[] args) {
        Solution_772 sol = new Solution_772();
        System.out.println(sol.calculate("2-(6-8*2)+8"));

    }
}
