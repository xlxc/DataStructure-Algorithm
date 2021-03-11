package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2021/03/10 22:06
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class Solution_55 {
// 2 3 1 1 4
    // 思路：当到达某个位置的时候，我们看从该位置上可以向后跳的最大的位置 maxReach是多少，
    // 到达数组的末尾的时候，当 maxReach 比数组的长度要大，说明我们就可以跳到数组最后位置，否则就不行
    public boolean canJump(int[] nums) {
        // base case
        if (nums == null || nums.length < 2) {
            return true;
        }
        int maxReach = nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            // 当前位置i，它可以跳到的的位置最多是：当前的数组下标 + 该元素值
            // 注意：如果此时不能跳到下一个，则无法更新
            if (maxReach < i) {
                return false;
            }
            // 更新 maxReach
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length-1;
    }

    public static void main(String[] args) {
        Solution_55 sol = new Solution_55();
        int[] a = {2,3 ,1 ,1 ,4};
        System.out.println(sol.canJump(a));
    }
}

// 0 2 3





















