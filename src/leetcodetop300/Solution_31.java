package leetcodetop300;

/**
 * @author: xuejing
 * @date: 2020/12/29 9:44
 * 31.下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_31 {

    // 题目要求是从只能在原数组上进行操作，不能使用额外的数组空间
    // 题目要求的是获得该排列的下一个较大的排列
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 从后相前遍历数组

    }


}
