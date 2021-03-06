package leetcodetop500;

import java.util.Stack;

/**
 * @author: xuejing
 * @date: 2020/12/09 10:55
 */
public class Solution_150 {

    /**
     * 逆波兰式是一种后缀表达式，所谓后缀指的是运算符写在要操作的两个数字的后面
     * 适合于用栈进行操作：遇到数字则入栈，遇到运算符则取出两个数字进行计算，并将结果压入栈中
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                int nums1 = stack.pop();
                int nums2 = stack.pop();
                switch (str){
                    case "+":
                        stack.push(nums2 + nums1);
                        break;
                    case "-":
                        stack.push(nums2 - nums1);
                        break;
                    case "*":
                        stack.push(nums2 * nums1);
                        break;
                    case "/":
                        stack.push(nums2 / nums1);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution_150 solution_150 = new Solution_150();
        String[] tokens = new String[] {"2", "1", "+", "3", "*"};
        System.out.println(solution_150.evalRPN(tokens));
    }
}
