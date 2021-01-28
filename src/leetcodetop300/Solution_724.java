package leetcodetop300;

import java.util.Arrays;

/**
 * @author: xuejing
 * @date: 2021/01/28 9:01
 * 724. 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_724 {

    // 此题可以采用前缀和，首先我们计算出数组中所有元素的和 sum，然后遍历数组，到达 nums[i] 时，
    // nums[i] 左侧元素的和为 leftSum，右侧元素的和为 sum-leftSum - nums[i]，
    // 当二者相等时候，则直接返回 i
    public int pivotIndex(int[] nums) {
        // 计算数组中所有元素之和
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum ==  sum-leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
