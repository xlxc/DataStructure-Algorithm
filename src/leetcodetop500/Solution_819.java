package leetcodetop500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: xuejing
 * @date: 2021/03/16 23:27
 * 明天的计划：训练字符串简单题：将通过率低于50%的简单题都做一下
 */
public class Solution_819 {

    // 此题的解题思路很简单，就是常规的解题步骤，需要考虑以下几种情况：
    // 1.如何根据空格和逗号将字符串分割成字符数组     -- 考虑使用正则表达式
    // 2.如何将字符串中的所有大写字母都转换成小写字母
    // 3.如何遍历的时候，根据字符串的出现的次数进行排序 -- 考虑使用 TreeMap
    // 对于情况1，由于题目不只是包括字母和逗号，还有其他的符号，所以无法使用正则表达式
    // 对于情况2，需要将字符串中的所有大写字母都转换成小写，需要逐个进行遍历
    // 对于情况3，直接使用 hashMap 记录字符串出现的次数，并用一个全局变量来计算 最多的次数即可
    // 综上所述，直接遍历字符串，在遍历的过程中，需要判断每单个字符是是否是字母，若是字母，需要将其转换成小写，
    // 并对连续的字母进行拼接
    public String mostCommonWord(String paragraph, String[] banned) {
        // base case
        if (paragraph == null || paragraph.length() == 0) {
            return paragraph;
        }
        // 注意：这里最后 一定要人为拼接一个非字母，否则最后一个字符是统计不到的
        paragraph += ".";
        // 题目已经说明 禁用列表中的单词用小写字母表示，所以直接加入即可
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        int maxCount = 0;
        String ans = "";

        HashMap<String,Integer> map = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            // 判断是否是字母
            if (Character.isLetter(c)) {
                // 将所有的字母都转换成小写
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                // 如果不是字母，说明就要在此处中断了，需要将其加入到 hashMap 中
                String finalStirng = word.toString();
                // 可以在遍历的时候同时判断是否是 禁用单词
                if (!set.contains(finalStirng)) {
                    map.put(finalStirng, map.getOrDefault(finalStirng, 0) + 1);
                    int count = map.get(finalStirng);
                    if (count > maxCount) {
                        maxCount = count;
                        ans = finalStirng;
                    }
                }
                // 注意：这里一定要重置字符串
                word = new StringBuilder();
            }
        }
        return ans;
    }
}
