package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/11/26 22:42
 */
public class Solution_39 {

    public static void main(String[] args) {
        Solution_39 solution_39 = new Solution_39();
        int[] arr = new int[] {2, 3, 6, 7};
        int target = 7;
        System.out.println(solution_39.combinationSum(arr, target).toString());

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, path, res, target);
        return res;
    }

    /**
     * @param candidates
     * @param begin: 指代下一次循环应该从该节点开始，而不再循环之前的节点（防止重复）,
     * 例如题解的[2,3,6,7],在走到3这一条路时，设置begin可以使回溯走3->3 这条路，而不是重复走 3 -> 2这条路，造成重复
     * @param path
     * @param res
     * @param target
     */
    private void dfs(int[] candidates, int begin, List<Integer> path, List<List<Integer>> res, int target) {
        // 由于每个数都可以被多次重复选择
        // base case : target < 0 的时候
        if (target < 0) {
            return;
        }
        // 什么时候将符合条件的结果加入 res 中呢？
        // 肯定是 target == 0 的时候
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 这里要从 begin 开始,如果不从 begin 开始，结果中就会有重复的组合
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            // 关键点:不用 i+1了，用i表示可以重复读取当前的数
            // 注意：这里的 begin 就变成了i哦
            dfs(candidates, i, path, res, target - candidates[i]);
            // 回溯，撤销选择
            path.remove(path.size() - 1);
        }
    }
}
