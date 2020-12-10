package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/12/08 16:02
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * <p>
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * <p>
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * <p>
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_842 {
    /**
     * 此题采用回溯解决，算是一种暴力枚举的方式，把字符串不断地截取，看一下能不能构成斐波拉契数列，
     * 如果不能就回到上一步，如果能就继续往下走
     *
     * @param str
     * @return
     */
    public List<Integer> splitIntoFibonacci(String str) {
        List<Integer> res = new ArrayList<>();
        dfs(str.toCharArray(), res, 0);
        return res;
    }

    private boolean dfs(char[] array, List<Integer> res, int index) {
        // base case
        // 因为题目要求的答案只有一种结果，且斐波拉契数列的定义是元素的个数是要大于3
        if (index == array.length && res.size() >= 3) {
            return true;
        }
        // 深度优先搜索
        return false;
    }

    public static void main(String[] args) {

    }
}









