package 计算器问题;

import sun.util.resources.hr.CalendarData_hr;

import javax.swing.*;
import java.beans.beancontext.BeanContext;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: xuejing
 * @date: 2021/01/01 17:51
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 */
public class Solution_224 {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int num = 0;
        int res = 0;
        // 1 代表正好，-1代表符负号
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res = res + sign * num;
                //将参数重置
                num = 0;
                sign = c == '+' ? 1 : -1;
            // 遇到左括号，将结果和括号前的运算保存，然后将参数重置
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                // 将右括号前的运算结束
                res = res + sign * num;
                // 将之前的结果和操作取出来和当前结果进行运算
                int signBefore = stack.pop();
                int resBefore = stack.pop();
                res = resBefore + signBefore * res;
                // 将参数重置
                sign = 1;
                num = 0;
            }
        }
        res = res + sign * num;
        return res;
    }

    public static void main(String[] args) {
        Solution_224 sol = new Solution_224();
        System.out.println(sol.calculate("2-2+3-1+5"));
    }
}
