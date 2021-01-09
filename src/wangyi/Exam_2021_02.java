package wangyi;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2021/01/06 10:01
 * 小易参加了一次考试，这场包含 n 个题目，第 i 个题目的分数是 si 。
 * 如果小易第 i 题目回答正确，他将得到 Si 分，否则该题目他将得到 0 分。
 * 最终的考试得分是所有题目得分的总和。
 * 由于阅卷老师很讨厌数字 5，在阅卷时如果一个学生的考试总分中含有数字 5，那么阅卷老师将气愤地给他 0 分。
 * 那么小易考试的最高得分是多少？
 */
public class Exam_2021_02 {
    static int max_values = Integer.MIN_VALUE;

    /**
     * 本题其实是求解最优化的问题
     * 对于求解最优化的问题，可以使用贪心、动态规划、回溯等
     * 解题的思路就是先写出暴力枚举的算法，然后在优化这个暴力枚举的代码
     * 对于这道题，我们可以枚举组合，然后看哪个组合的分数最高，同时还要求该分数中不能含有数字5即可
     * 枚举每个数组
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] memo = new int[nums.length + 1];
        process(nums, 0, 0,memo);
        System.out.println(max_values);
    }

    /**
     * 典型的从左向右的模型：对于当前index 值有两种选择，可以选或者不选
     *
     * @param nums
     * @return
     */
    public static int process(int[] nums, int index, int pathSum,int[] memo) {
        // base case
        if (index == nums.length) {
            if (!isContainsFive(pathSum)) {
                max_values = Math.max(max_values, pathSum);
            }
            return 0;
        }
        if (memo[index] != 0) {
            return memo[index];
        }
        // 当前 index 值选
        int p1 = process(nums, index + 1, pathSum + nums[index],memo);
        // 当前 index 值不选
        int p2 = process(nums, index + 1, pathSum,memo);
        memo[index] = Math.max(p1, p2);
        return Math.max(p1, p2);

    }

    public static boolean isContainsFive(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '5') {
                return true;
            }
        }
        return false;
    }
}
