package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2020/12/09 11:19
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_153 {

    public int findMin(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 由于数组是将排序数组进行了旋转，那么最小的元素即为当前元素大于后面一个元素时
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Solution_153 solution_153 = new Solution_153();
        int[] array = new int[] {1};
        System.out.println(solution_153.findMin(array));
    }

}
