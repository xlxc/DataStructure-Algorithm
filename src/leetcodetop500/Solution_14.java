package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2020/12/08 16:42
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Solution_14 {

    public static void main(String[] args) {
        Solution_14 solution_14 = new Solution_14();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution_14.longestCommonPrefix(strs));
    }

    /**
     * 本题直接使用暴力解法，两两比较字符串的最长公共前缀，
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            // 如果匹配的下标不是0，说明当前的 prefix 不是最长的公共前缀
            // 此时要将 prefix 的最后的一个字符去掉，然后在此匹配，直到匹配成功为止
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
