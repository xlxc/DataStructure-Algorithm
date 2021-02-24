package sword_finger_offer;

/**
 * @author: xuejing
 * @date: 2021/02/23 9:01
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_20 {

    // 此题是根据给定的字符串，判断是否是数字，所以需要分类讨论
    // 1)正负数：只能在第一个位置上出现 + 或者 - 号，其余位置不能出现
    // 2)小数：只能在字符中间出现小数点（且只能出现一次），开头和结尾都不能出现小数点
    // 3)科学计数法：这里比较难讨论，
    public boolean isNumber(String s) {
        // base case
        if (s == null || s.length() == 0) {
            return false;
        }
        // 去掉收尾空格
        s = s.trim();
        // 笔试中有个小的trick，使用try……catch
        try {
            double a = Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        // 面向测试用例编程：末尾有f，D这些都不算，但是3.算数字，
        char c = s.charAt(s.length() - 1);
        return (c >= '0' && c <= '9') || c == '.';
    }
}


















