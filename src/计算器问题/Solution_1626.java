package 计算器问题;

import java.beans.beancontext.BeanContext;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: xuejing
 * @date: 2021/01/01 10:58
 * 面试题 16.26. 计算器
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculator-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1626 {

    // 对于计算器问题，可以借助于栈来使用
    // 此题需要计算的表达式只含有 +、-、*、/ 这四个符号，但是要主要 乘除的优先计算
    public int calculate(String s) {
        // base case
        if (s == null || s.length() == 0) {
            return 0;
        }

        // core
        // 考点1；在遍历字符串时，如何将为止长度连续的字符串=转换成数字
        // 考点2：如何处理乘除 法的优先计算
        // 如果遇到乘除法，就取出栈顶元素并与当前元素进行计算
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for (Character c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                continue;
            } else if (Character.isDigit(c)) {
                // 将连续的字符转换成数字拼接
                num = num * 10 + (c - '0');
            } else {
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
                    default:
                        break;
                }
                num = 0;
                // sign 用于存储的数字前面的字符
                sign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "432+";
        int num = 0;
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
        }
        // 输出：432
        System.out.println(num);
    }
}
