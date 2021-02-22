package slidingWindow;

/**
 * @author: xuejing
 * @date: 2021/02/04 8:58
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class Solution643 {

    public static void main(String[] args) {
        Solution643 sol = new Solution643();
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(sol.findMaxAverage(nums, 4));
    }

    /**
     * 这是一道滑动窗口的题目，题目中已经给出了滑动窗口的固定大小是k，所以我们只要遍历所有的滑动窗口，然后取窗口中元素之和
     * 的最大值即可
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        int start = 0;
        int end = k;
        while (end < nums.length) {
            sum = sum - nums[start] + nums[end];
            maxSum = Math.max(maxSum, sum);
            end++;
            start++;
        }
        return 1.0 * maxSum / k;
    }
}
