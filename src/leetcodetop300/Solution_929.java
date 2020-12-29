package leetcodetop300;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: xuejing
 * @date: 2020/12/12 15:42
 */
public class Solution_929 {

    public static void main(String[] args) {
        Solution_929 sol = new Solution_929();
        String[] str = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(sol.numUniqueEmails(str));
    }

    /**
     * 这道题可以先按照题目的要求 将 @ 分成前面两个字符串，后面的域名不动
     * 我们要对前面的字符进行替换和截取，然后在将这两个字符拼接起来放入 set 集合中
     * 最后返回集合的大小即可
     *
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length <= 1) {
            return emails.length;
        }
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            // 1.先找到 @ 位置
            int atSign = email.indexOf('@');
            // 2.根据 @ 的位置将字符串分割
            String local = email.substring(0, atSign);
            String domain = email.substring(atSign, email.length());
            // 将前面的字符串中的 . 号全部替换成空格
            local = local.replaceAll("\\.", "");
            // 找出 + 的位置
            int plusSign = local.indexOf('+');
            // 注意：这里要有个判断，只有有+才进行分割
            if (plusSign >= 0) {
                local = local.substring(0, plusSign);
            }
            set.add(local + domain);
            System.out.println(local + domain);
        }
        return set.size();
    }
}
