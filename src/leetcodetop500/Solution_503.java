package leetcodetop500;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: xuejing
 * @date: 2021/03/06 18:49
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 */
public class Solution_503 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // 因为若元素没有下一个更大的元素，则需要设为-1，所以数组的初始默认值设为-1
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        // 循环数组，使用%
        for (int i = 0; i < len * 2 - 1; i++) {
            // 只有当栈中元素不为空，且数组的当前元素比栈顶元素大的时候，就弹出栈顶元素，且栈顶元素的下个更大元素就是当前元素
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                int index = stack.pop();
                res[index] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}
