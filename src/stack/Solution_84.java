package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: xuejing
 * @date: 2020/12/26 15:06
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Solution_84 {

    // 我们可以遍历每根柱子，对于某个柱子i，高度即为矩形的高，那么矩形的宽度边界
    // 就是向左，向右进行延伸，当向左、向右遇到第一个高度小于当前柱体i的即可
    // 对于每根柱子都要如上计算一遍，最终比较出最大的矩形面积即可
    // 此题核心就是求 向左、向右求 next smaller element(次小元素)
    // 使用单调栈：次小的元素应该使用 从栈底到栈顶应该是 从小到大 的

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        // 为了代码简便，在数组的头尾加上两个高度为0的柱体
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights, 0, temp, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] > temp[i]) {
                // 栈中元素弹出，就计算面积
                int h = temp[stack.pop()];
                // 此时元素i就是栈顶元素右边的次小元素，而栈顶元素左边的次小元素就是栈中的下一个相邻的元素
                maxArea = Math.max(maxArea, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
