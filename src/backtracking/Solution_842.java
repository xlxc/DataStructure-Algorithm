package backtracking;

import java.awt.font.NumericShaper;
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

    // index 表示所到达的数组中的下标
    private boolean dfs(char[] array, List<Integer> res, int index) {
        // base case
        // 因为题目要求的答案只有一种结果，且斐波拉契数列的定义是元素的个数是要大于3
        if (index == array.length && res.size() >= 3) {
            return true;
        }
        // 深度优先搜索
        long currNum = 0;
        // index 可以看成是 递归树的某一层上，i 在 index 的基础上不断地向下搜索
        for (int i = index; i < array.length; i++) {
            // 首先，当拆分的数字大于两位时，其头部不能是0
            if (array[index] == '0' && i > index) {
                break;
            }
            // 截取字符串转换成数字
            currNum = currNum * 10 + array[i] - '0';
            // 如果数字大于 int 的最大值，也要去掉
            if (currNum > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int)currNum;
            // 如果截取的数字大于 res 中前两个数字的和，说明这次截取的太大了，直接终止
            int size = res.size();
            if (size >= 2 && curr > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            // 当 res 中的个数不足两个，或者截取的数刚好等于 前两个数字的和，就加入 res 中
            if (size < 2 || curr == res.get(size - 1) + res.get(size - 2)) {
                // 把数字添加到 res 中
                res.add(curr);
                // 如果找到了就直接返回
                if (dfs(array, res, i + 1)) {
                    return true;
                }
                // 如果没找到，就要回溯到上一步，把上一步的添加到 res 中的元素删除
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}









