package greedy;

import java.util.Arrays;

/**
 * @author: xuejing
 * @date: 2020/12/25 9:12
 * 455.分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
 * 都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_455 {

    // 可以使用贪心的思想：将最小的饼干分给胃口最小的孩子，这样就能保证足够多的孩子可以吃到饼干
    // 所以，事先要将数组进行排序
    // g 是孩子的胃口，s是饼干的大小
    // 要是的 s[i] > g[i]
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0, j = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                i++;
                j++;
                res++;
            } else if (s[i] < g[j]) {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_455 sol = new Solution_455();
        int[] g = {1, 2, 3};
        int[] s = {3};
        System.out.println(sol.findContentChildren(g, s));
    }

}
