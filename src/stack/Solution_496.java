package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xuejing
 * @date: 2020/12/26 19:56
 * 496. 下一个更大元素 I
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_496 {

    // 我们先可以忽略数组 num1，先用单调栈求出数组 nums2 中每个元素下一个次大元素，随后将这些答案存入到 HashMap
    // 然后在遍历 nums1，直接可以找出答案

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        // 先找出数组 nums2 中每个元素的下一个次大元素，栈中元素从底部向上，从大到小
        // 当元素i 大于栈顶元素时，就将栈顶元素出栈，此时出栈的元素的下一个次大的值就是元素i
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            // 注意：栈中存储的是数组的下标
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int idx = stack.pop();
                map.put(nums2[idx], nums2[i]);
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

}
