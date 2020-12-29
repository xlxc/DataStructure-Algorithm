package 股票问题;

import java.security.PrivateKey;

/**
 * @author: xuejing
 * @date: 2020/12/28 9:26
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_188 {

    // 和之前的不同的是，之前的题目要求的是最多 1次、2次
    // 而这题要求的是 最多 k 次

    //    我们可以用3个变量来表示买卖k次的交易状态：
    //    index，用来表示当前是哪一天；
    //    status，用来表示当前是买入、还是卖出；
    //    count，用来表示交易了几次；
    //    1）如果状态是是买入:
    //        那么可以保持不动 或者马上卖掉
    //    2）如果状态是卖出:
    //    可以保持不动(等待更好的股价出现，暂时不买) 或者立马再买一股，同时将count数+1，表示交易过一次了

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        return dfs(prices, k, 0, 0, 0);
    }

    // 计算k次交易，index表示当前是哪天，status是买卖状态，coutnt为交易次数
    private int dfs(int[] prices, int k, int index, int status, int count) {
        // base case: 什么时候结束
        if (index == prices.length || count == k) {
            return 0;
        }
        // 对于当前 index 的股票，有两种选择：保持不动，动（还需判断是买入还是卖出）
        // 保持不动
        int a = dfs(prices, k, index + 1, status, count);
        // 动，需要根据状态来判断是买入还是卖出
        int b = 0, c = 0;
        if (status == 1) {
            // 卖一股，并将交易次数+1
            b = dfs(prices, k, index + 1, 0, count + 1) + prices[index];
        } else {
            // 买一股
            c = dfs(prices, k, index + 1, 1, count) - prices[index];
        }
        return Math.max(Math.max(a, b), c);
    }
}
