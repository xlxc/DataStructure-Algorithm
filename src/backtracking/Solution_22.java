package backtracking;

import sun.awt.SunGraphicsCallback;

import java.awt.*;
import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/11/28 17:14
 * 22.括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Solution_22 {

    public static void main(String[] args) {
        Solution_22 solution_22 = new Solution_22();
        System.out.println(solution_22.generateParenthesis(3).toString());
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        //        String path = "";
        //        char[] path = new char[2*n];
        List<String> path = new ArrayList<>();
        dfs(n, 0, 0, res, path);
        return res;
    }

    private void dfs(int n, int leftNum, int rightNum, List<String> res, List<String> path) {
        if (leftNum > n || rightNum > n) {
            return;
        }
        if (leftNum == n && rightNum == n) {
            StringBuilder sb = new StringBuilder();
            for (String item : path){
                sb.append(item);
            }
            res.add(sb.toString());
            return;
        }
        if (leftNum >= rightNum) {

            path.add("(");
            dfs(n, leftNum + 1, rightNum, res, path);
            path.remove(path.size() - 1);

            path.add(")");
            dfs(n, leftNum, rightNum + 1, res, path);
            path.remove(path.size() - 1);
        }
    }

    //    /**
    //     * 方法一
    //     * @param n
    //     * @param leftNum
    //     * @param rightNum
    //     * @param res
    //     * @param path
    //     */
    //    private void dfs(int n, int leftNum, int rightNum, List<String> res, String path) {
    //        // base case
    //        // 当到达某位时，左括号的数量和右括号的数量不相等，说明不是有效的
    //        if (leftNum > n || rightNum > n) {
    //            return;
    //        }
    //        if (leftNum == n && rightNum == n) {
    //            res.add(path);
    //            return;
    //        }
    //        // 核心在这里
    //        if (leftNum >= rightNum) {
    //            // 第 idnex 位置选择左括号
    //            // 这里为什么不需要回溯呢，因为是由于字符串的特殊性，每次字符串的拼接都会生成一个新的对象，
    //            // 因此无需回溯
    //            dfs(n,  leftNum + 1, rightNum, res, path + "(");
    //            // 第 index 位置选择右括号
    //            dfs(n,  leftNum, rightNum + 1, res, path + ")");
    //        }
    //    }

}
