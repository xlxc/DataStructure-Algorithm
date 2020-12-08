package backtracking;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/11/27 10:42
 */
public class Solution_90 {

    public static void main(String[] args) {
        Solution_90 solution_90 = new Solution_90();
        int[] arr = new int[] {1, 2, 2};
        System.out.println(solution_90.subsetsWithDup(arr).toString());
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        //        if (index == nums.length) {
        //            return;
        //        }
        // 由于是子集问题，每个路径都是结果
        res.add(new ArrayList<>(path));
        // 从 index 开始时因为
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }

            path.add(nums[i]);
            // i+1 代表一个元素只能选择一次
            dfs(nums, i +1, path, res);
            path.remove(path.size() - 1);
        }
    }




}
