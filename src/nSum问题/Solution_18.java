package nSum问题;

import java.awt.image.RGBImageFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2021/01/02 18:24
 */
public class Solution_18 {

    List<List<Integer>> res = new ArrayList<>();
    // 注意:调用这个函数之前，需要事先给数组排好序
    public List<List<Integer>> nSumTargets(int[] nums, int n, int start, int target) {
        if (n < 2 || n > nums.length) return res;
        // 2-Sum 是 base case
        if (n == 2) {
            // 双指针那一套
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int low = nums[left];
                int high = nums[right];
                if (sum < target) {
                    // 去重，跳过所有相邻的重复元素
                    while (left < right && low == nums[left])
                        left++;
                } else if (sum > target) {
                    while (left < right && high == nums[right])
                        right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (left < right && low == nums[left])
                        left++;
                    while (left < right && high == nums[right])
                        right--;
                }
            }
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = start; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<List<Integer>> sub = nSumTargets(nums, n - 1, i + 1, target - nums[i]);
                // (n-1)Sum 加上 nums[i]，就是结果
                for (int j = 0; j < sub.size(); j++) {
                    List<Integer> list = sub.get(j);
                    list.add(nums[i]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        nSumTargets(nums, 4, 0, target);
        return res;
    }

    public static void main(String[] args) {
        Solution_18 sol = new Solution_18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        Arrays.sort(nums);
        System.out.println(sol.nSumTargets(nums, 4, 0, 0));

    }

}
