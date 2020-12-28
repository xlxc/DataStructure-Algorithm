package didi;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2020/12/27 14:32
 * 1.连续最大和
 * 题目描述
 * 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
 */
public class DD1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(maxSum(nums));
    }

    // 此题可以使用贪心的思想，遍历一次数组，
    // 计算以当前数字为结尾的连续序列的最大值，然后取最大的即可
    // 如何计算以当前数字为结尾的连续序列的最大值呢？

    private static int maxSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxCurr = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            // 注意：这里比较的是 num 和 maxCurr + num
            // 因为题目要求是的连续的序列，如果当前值要，则是 maxCurr + num
            // 如果当前值不要，那么前面的 maxCurr 也不能要，否则从 num 开始就断开了
            // 所有，要么 num + 之前所有的，要么是就当前 num 一个值
            maxCurr = Math.max(num, maxCurr + num);
            res = Math.max(res, maxCurr);
        }
        return res;
    }
}
