package greedy;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2020/11/30 18:49
 * @description: 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 */
public class Solution_767 {

    /**
     * 思路：首先当字符串中某个字符出现的次数大于 n/2时，那么就不可能做到任意两个字符不相邻。
     *
     * @param str
     * @return
     */
    public String reorganizeString(String str) {

        if (str == null || str.length() == 0) {
            return "";
        }
        // 首先算出字符串中出现次数最多的是多少
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (Character chs : str.toCharArray()) {
            if (map.containsKey(chs)) {
                map.put(chs, map.get(chs) + 1);
                maxCount = Math.max(maxCount,map.get(chs));
            } else {
                map.put(chs, 1);
            }
        }
        if (maxCount > (str.length()/2 )) {
            return "";
        }
        // 如果可以，则使用大根堆
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return 0;
            }
        });


        return "";
    }

    private void process() {

    }
}
