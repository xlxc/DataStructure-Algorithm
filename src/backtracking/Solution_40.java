package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/11/27 9:59
 * @description: 40.组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
public class Solution_40 {

    public static void main(String[] args) {
        Solution_40 solution_40 = new Solution_40();
        int[] arr = new int[] {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(solution_40.combinationSum2(arr, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        // 关键步骤，需要排序，否则后面无法剪枝取出重复的组合
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int target, List<Integer> path, List<List<Integer>> res) {
        // base case
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 剪枝，去除重复组合
            // i > begin
            if (i > begin && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }

}









