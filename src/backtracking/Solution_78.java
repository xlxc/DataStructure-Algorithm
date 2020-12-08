package backtracking;

import com.sun.xml.internal.txw2.output.IndentingXMLFilter;
import jdk.nashorn.internal.ir.ReturnNode;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/11/27 10:25
 * 78.子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class Solution_78 {

    public static void main(String[] args) {
        Solution_78 solution_78 = new Solution_78();
        int[] arr = new int[] {1, 2, 3};
        System.out.println(solution_78.subsets(arr).toString());
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
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
            path.add(nums[i]);
            // i+1 代表一个元素只能选择一次
            dfs(nums, i +1, path, res);
            path.remove(path.size() - 1);
        }
    }

}
