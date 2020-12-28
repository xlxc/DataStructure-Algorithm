package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: xuejing
 * @date: 2020/12/26 15:45
 * 单调栈的模板：单调栈分为单增和单减栈
 * 规律：求下一个较大元素：单调栈：从栈底到栈顶是 依次减小的（因为需要求大，大的时候出栈即为结果）
 *      求下一个较小元素：单调栈：从栈底到栈顶是 依次增大的（因为需要求小，小的时候出栈即为结果）
 */
public class Template {

    // 对于单调栈的题目来说，数组中的每个元素都会进入栈中一次
    // 所有对于当前某个数字i的结果都是在当前元素出栈的时候得到的
    // 当元素i 大于栈顶元素时，说明栈顶元素的下一个次大的元素就是元素i
    // 根据上面的讨论可以知道：
    // 当求元素的下一个较大的值时，单调栈中的元素应该是 从栈底到栈顶是：依次减小(因为需要求大，大的时候出栈即为结果)
    private int[] nextGreaterElement(int[] array){
        if (array == null || array.length == 0) {
            return array;
        }
        int[] res = new int[array.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                int idx = stack.pop();
                res[idx] = array[i];
            }
            // 注意：这里栈中存的是元素的下标，因为数组中的元素值可能是重复的
            stack.push(i);
        }
        return res;
    }

    // 求下一个较小元素，那么当遍历到的元素i要小于栈顶元素时才出栈，出栈的元素的下一个较小元素就是元素i
    // 故单调栈中 从栈底到栈顶是：依次增大的（小的时候才不符合单调栈的要求，才出栈）
    private int[] nextSmallerElement(int[] array){
        if (array == null || array.length == 0) {
            return array;
        }
        int[] res = new int[array.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
                int idx = stack.pop();
                res[idx] = array[i];
            }
            stack.push(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 2, 1, 5, 6, 1};
        Template template = new Template();
        System.out.println(Arrays.toString(template.nextGreaterElement(arr)));
        System.out.println(Arrays.toString(template.nextSmallerElement(arr)));
//        2, 3, 1, 1, 2, 1, 5, 6, 1
//        3  5  2  2  5  5  6  0  0
//
//        大   小
//        3  1  1

    }
}
