package slidingWindow;

import java.util.LinkedList;

/**
 * @author: xuejing
 * @date: 2020/08/28 14:33
 * 239. 滑动窗口最大值 hard
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] a = maxSlidingWindow(nums, k);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

    /**
     * @param nums
     * @param k
     * @return 如何求滑动窗口中数的最大值（最小值）？
     * 使用单调双端队列：LinkedList
     * 1.定义一个双端队列，要求队列中的元素从队列头到队列尾是严格单调的，最大值（从大到小）
     * 2.每次滑动窗口加一个数时（即R++），将该数与队列的尾部的数进行比较，若比尾部的数小，则直接加入到队尾；
     * 若比尾部的数大（或相等），则将尾部的数出队，并继续比较，直到小为止
     * 3.每次滑动窗口减一个数时（即L++），将该数的下标与队列头部进行比较，若相等，说明该数就是过期的元素，
     * 从队头移除
     * 4. 每次队列的头部的元素即是滑动窗口的最大值
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return null;
        }
        // 定义双端队列
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int R = 0; R < nums.length; R++) {
            // 向队尾添加元素,若队列不为空，且队尾的元素小于等于当前值，就将队尾元素出队
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[R]) {
                qMax.pollLast();
            }
            // 添加的是下标
            qMax.addLast(R);
            // L……R
            // L = R - k
            // 如果 当前过期的元素和队尾相等就弹出
            if (R - k == qMax.peekFirst()) {
                qMax.pollFirst();
            }
            // 当滑动窗口的大小满足给定的k的时候，就给res 数组赋值
            if (R - k >= -1) {
                // 注意队列中存储的是下标
                res[index++] = nums[qMax.peekFirst()];
            }
        }
        return res;
    }
}
