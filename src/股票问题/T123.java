package 股票问题;

/**
 * @author: xuejing
 * @date: 2020/10/27 19:05
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 本题可以使用动态规划求解，先从暴力递归开始
 * 这一题是典型的从左向右的尝试模型，对于当前天，我们可以选择 买或不买股票，卖或不卖股票
 * 当前天买或不买，要取决于此时手中还有没有股票，若没有则可以买，都这不可以买，只能卖
 */
public class T123 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // dp[i][j][0]：表示第i天交易了
        int[][][] dp = new int[prices.length+1][2][3];
        return f1(prices, 0, 0, 0, dp);
    }

    //--------------------记忆化搜索------------------------------------------
    /**
     * 对于记忆化搜索，暴力递归中有几个可变参数，那么就用几维的数组来存储结果
     * @return
     */
    public static int f1(int[] prices, int i, int hasStock, int count, int[][][] dp) {
        // base case: 已经到了最后一天，直接返回
        // 或者已经完成了两次交易,且手上已经没有股票了
        if (dp[i][hasStock][count] != 0) {
            return dp[i][hasStock][count];
        }
        if (i == prices.length || (count >= 2 && hasStock < 1)) {
            return 0;
        }
        // 若此时手上没有股票，则当前天数考虑：买 or 不买
        if (hasStock <= 0) {
            // 买当前股票
            int p1 = -prices[i] + f1(prices, i + 1, 1, count + 1,dp);
            // 不买当前股票
            int p2 = f1(prices, i + 1, 0, count, dp);
            dp[i][hasStock][count] = Math.max(p1, p2);
            return dp[i][hasStock][count];
        }
        // 若此时手上有股票，则当前天数考虑：卖 or 不卖
        // 卖当前股票
        int s1 = prices[i] + f1(prices, i + 1, 0, count, dp);
        // 不卖当前股票
        int s2 = f1(prices, i + 1, 1, count, dp);
        dp[i][hasStock][count] = Math.max(s1, s2);
        return dp[i][hasStock][count];
    }
    //--------------------记忆化搜索------------------------------------------

    //--------------------暴力递归：会超出时间限制--------------------------------
    /**
     * @param prices
     * @param i:来到第i 天
     * @param hasStock：手上是否持有股票
     * @param count：前面0~i-1 天已经完成的交易数
     * @return
     */
    public static int f(int[] prices, int i, int hasStock, int count) {
        // base case: 已经到了最后一天，直接返回
        // 或者已经完成了两次交易,且手上已经没有股票了
        if (i == prices.length || (count >= 2 && hasStock < 1)) {
            return 0;
        }
        // 若此时手上没有股票，则当前天数考虑：买 or 不买
        if (hasStock <= 0) {
            // 买当前股票
            int p1 = -prices[i] + f(prices, i + 1, 1, count + 1);
            // 不买当前股票
            int p2 = f(prices, i + 1, 0, count);
            return Math.max(p1, p2);
        }
        // 若此时手上有股票，则当前天数考虑：卖 or 不卖
        // 卖当前股票
        int s1 = prices[i] + f(prices, i + 1, 0, count);
        // 不卖当前股票
        int s2 = f(prices, i + 1, 1, count);
        return Math.max(s1, s2);
    }
    //--------------------暴力递归：会超出时间限制--------------------------------


}
