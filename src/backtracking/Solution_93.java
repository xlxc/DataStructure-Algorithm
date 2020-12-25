package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/12/25 13:57
 * 93.复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_93 {

    // 可以使用暴力递归来实现，暴力递归的本质就是枚举所有的可能性，
    // 但是在暴力枚举的过程中需要将不符合的路径及时返回，不需要在深入的搜索下去，这就是回溯

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        // 如果字符串的长度小于4，大于12，肯定不能组成IP地址的
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        dfs(s, 0, 0, path, res);
        return res;
    }

    // begin: 目前所处在字符串的下标位置
    // split：已经分割的段数

    private void dfs(String s, int begin, int split, Deque<String> path, List<String> res) {
        // 什么时候符合条件，将结果存储起来
        // 当已经遍历到字符串的尾部，同时，分割的段数是4，才是符合的
        if (begin == s.length()) {
            if (split == 4) {
                res.add(String.join(".", path));
            }
            return;
        }
        // 若剩下的字符串的长度不够了，或者多了，也直接返回
        // 因为合法的IP地址是每一位的长度是 1-3 之间
        int restLength = s.length() - begin;
        if (restLength < 4 - split || restLength > 3 * (4 - split)) {
            return;
        }
        // 递归树的向下的分支个数，由于每次最多是选1个字符、2个字符、3个字符，即这是一个三叉树
        for (int i = 0; i < 3; i++) {
            // 注意，在for循环中，不能使用return，只能使用 brake 或者 continue 来跳出循环
            if (begin + i >= s.length()) {
                break;
            }
            // 将分割的字符串转换成数字，同时需要验证是否符合要求：要在 0-255 之间
            if (judgeIfIpSegments(s, begin, begin + i)) {
                // 在判断是 ip 段的情况下，才去做截取
                String currentIpSegment = s.substring(begin, begin + i + 1);
                path.addLast(currentIpSegment);
                dfs(s, begin + i + 1, split + 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIfIpSegments(String s, int start, int end) {
        int len = end - start + 1;
        // 字符大于1位的时候，不能以‘0’开头
        if (len > 1 && s.charAt(start) == '0') {
            return false;
        }
        // 将字符串 转换成 int 类型
        int res = 0;
        for (int i = start; i <= end; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res <= 255;
    }

}
