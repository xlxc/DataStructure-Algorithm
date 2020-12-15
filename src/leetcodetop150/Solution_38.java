package leetcodetop150;

/**
 * @author: xuejing
 * @date: 2020/12/10 9:52
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_38 {

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        // 初始化当前的指针和前一个指针
        StringBuilder pre = new StringBuilder("1");
        StringBuilder cur = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            pre = cur;
            cur = new StringBuilder();
            int start = 0;
            int end = 0;
            // 开始遍历前一项，开始描述
            while (end < pre.length()) {
                while (end < pre.length() && pre.charAt(start) == pre.charAt(end)) {
                    end++;
                }
                //元素出现次数与元素进行拼接
                cur = cur.append(Integer.toString(end - start)).append(pre.charAt(start));
                start = end;
            }
            String.valueOf(1);
            Integer.parseInt("1");
            Integer.valueOf("1");
            

        }
        return cur.toString();
    }

}
