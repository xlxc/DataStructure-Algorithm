package leetcodetop300;

/**
 * @author: xuejing
 * @date: 2020/12/09 10:07
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 说明：
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_151 {

    public String reverseWords(String str) {
        // base case
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        // 首先去除字符串首尾的空格
        str = str.trim();
        // 按照空格分割字符串（支持多个空格）
        String[] strs = str.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            res.append(strs[i]);
            res.append(" ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution_151 solution_151 = new Solution_151();
        System.out.println(solution_151.reverseWords("  Bob    Loves  Alice   "));

    }
}
