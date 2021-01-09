package wangyi;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2021/01/06 9:18
 * 网易2021校招笔试-移动端安全开发工程师（杭研）
 * 给定长度为m的序列T，求一个长度为n且字典序列最小的排列，并且要求序列T为所求排列的子序列。
 * 题目保证这样的排序一定存在。
 */
public class Exam_2021_01 {

    // 做算法题，首先要理解题目的意思，才能开始下手写代码，否则很难写出来
    // 这道题的要求是：
    // 题目给出长度为 m 的序列 T,要求我们输出长度为 n 的序列S，但是要求输入的序列T 是序列S的子序列即可
    // 思路：从1~n的数字中去除T序列包含的数字，则会得到候选数组arr，然后将arr与T数组合并成一个数组即可
    // 这个合并后的数组肯定是包含序列S，同时也是字典排序最小的
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[m];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
            set.add(nums[i]);
        }
        int[] arr = new int[n - nums.length];
        for (int i = 1, j = 0; i <= n; i++) {
            if (!set.contains(i)) {
                arr[j++] = i;
            }
        }
        // 合并两个数组，类似于两个排序数组归并：arr 与 nums
        int[] res = new int[n];
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while (p1 < arr.length && p2 < nums.length) {
            if (arr[p1] > nums[p2]) {
                res[p3++] = nums[p2++];
            } else {
                res[p3++] = arr[p1++];
            }
        }
        // 会有一个指针没有走到尾部
        while (p1 < arr.length) {
            res[p3++] = arr[p1++];
        }
        while (p2 < nums.length) {
            res[p3++] = nums[p2++];
        }
        // 输出结果
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

}
