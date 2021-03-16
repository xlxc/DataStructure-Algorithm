package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2021/03/16 19:40
 */
public class Solution_540 {

    // 由于题目给出的是有序的数组，所以可以使用二分法
    // 其实这道题使用二分法的原因并不是因为是有序的，而是因为相同的元素是相邻的，只有一个元素是出现一次
    // 所以，元素的个数和一定是奇数，且删除了两个相同的元素后，哪边的元素个数是奇数，哪边就是只出现一次的
    //
    public int singleNonDuplicate(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 右半部分的元素和 是否是 偶数
            boolean rightIsArea = (right - mid) % 2 == 0;
            // 相同的元素在左边
            if (nums[mid] == nums[mid - 1]) {
                if (rightIsArea) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (rightIsArea) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
