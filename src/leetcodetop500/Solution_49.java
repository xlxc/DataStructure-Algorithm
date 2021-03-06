package leetcodetop500;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2020/12/14 10:43
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_49 {

    /**
     * 由题可知，对于字母异位词，当对该单词进行排序后，一定是相等的
     * 所以可先对每个单词进行排序，然后放入 map 中，map的key 就是 单词排序后的字符串，值就是原始的列表集合
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 先转换成字符数组才能排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> value = map.getOrDefault(key,new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }

}

















