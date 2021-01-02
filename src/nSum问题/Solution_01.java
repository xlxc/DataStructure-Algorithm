package nSum问题;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import stack.Solution_84;

import javax.swing.*;
import java.util.*;

/**
 * @author: xuejing
 * @date: 2021/01/02 16:59
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_01 {

    // 这个题有两种解法
    public List<List<Integer>> twoSum1(int[] nums, int target) {
        // base case
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                // 题目要求只找出一对即可
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(map.get(another));
                res.add(list);
                // 由于答案中需要去重，所以应该去除
                map.remove(another);
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int low = nums[left];
            int high = nums[right];
            if (sum < target) {
                // 去重，跳过所有相邻的重复元素
                while (left < right && low == nums[left])  left++;
            } else if (sum > target) {
                while (left < right && high == nums[right])  right--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                while (left < right && low == nums[left])  left++;
                while (left < right && high == nums[right])  right--;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution_01 sol = new Solution_01();
        int[] nums = {1, 3, 1, 2, 3, 2, 3, 4, 5, 0, 3};
        int targets = 3;
        System.out.println(sol.twoSum(nums, targets));
    }
}
