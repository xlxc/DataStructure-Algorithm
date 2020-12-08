package backtracking;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2020/11/25 21:47
 * 47.全排列2
 * 给定一个可包含 重复数字 的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Solution_47 {

    public static void main(String[] args) {
        Solution_47 solution_47 = new Solution_47();
        int[] arr = new int[] {1, 2, 1};
        System.out.println(solution_47.permuteUnique(arr).toString());
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        // 必须要先排序，使得相同的元素相邻，这样才可以剪枝
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path, res,used);
        return res;
    }

    private void dfs(int[] nums, int depth, List<Integer> path, List<List<Integer>> res,boolean[] used) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 前面已经选择了这个数，就不能在选择了
            if (used[i]) {
                continue;
            }
            // 剪枝，去重
            // i >0 : 保证后面的 i-1 是有效的
            // nums[i] == nums[i - 1]：当
            // used[i-1] == false: 是因为 nums[i-1] 在回退的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && used[i-1] ==  false){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, depth + 1, path, res,used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
