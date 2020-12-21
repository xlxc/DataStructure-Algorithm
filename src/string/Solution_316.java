package string;

import java.nio.charset.CharsetEncoder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author: xuejing
 * @date: 2020/12/19 12:22
 * 316.去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class Solution_316 {

    // 本题可以使用单调栈来解决
    // 依次遍历字母，将字母进栈，在栈中，从底到上，字母应该是依次变大
    // 若当前字母比栈顶元素要小，我们就要考虑是否要将栈顶元素移除:
    // 1). 若栈顶元素只出现过一次，或者栈顶元素在后序的遍历中不会在出现了，那么就不能移除
    // 2). 若当前元素已经在栈中了，那么也无需移除，继续遍历下一个
    // 根据以上分析，如何编码：
    // 1).需要数组或者哈希表来判断当前的元素在后序中是否会出现，由于题目给出的是小写字母，我们
    //    就可以使用 26 位的整型数组来解决，数组中存储的是字母最后一次出现的下标
    // 2).同时还要一个boolean数组来表示当前字母是否已经在栈中

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        // 记录每个字母最后一次出现的位置
        int[] lastIndex = new int[26];
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] isVisited = new boolean[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (isVisited[ch - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > ch && i < lastIndex[stack.peekLast() - 'a']) {
                char top  = stack.pollLast();
                isVisited[top - 'a'] = false;
            }
            stack.addLast(ch);
            isVisited[ch - 'a'] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pollFirst());
        }
        return stringBuilder.toString();
    }

//    public String removeDuplicateLetters(String s) {
//        if (s == null || s.length() < 2) {
//            return s;
//        }
//        // 由于在Java中，字符 char 的ASCII 值在 0-127之间，
//        // 所以,我们可以用 128 长度的 int 数组来代替 哈希表
//        int[] map = new int[128];
//        boolean[] isExists = new boolean[128];
//        char[] chs = s.toCharArray();
//        // 统计每个字符出现的次数
//        for (char c : chs) {
//            map[c]++;
//        }
//        Deque<Character> stack = new ArrayDeque<>();
//        for (char c : chs) {
//            // 当栈不为空时，并且栈中的元素要大于 此时的字符，且栈中元素剩下的个数不能为0，不然不能出栈
//            while (!stack.isEmpty() && stack.peek() >= c && map[stack.peek()] > 0) {
//                isExists[stack.peek()] = false;
//                stack.pollFirst();
//            }
//            if (!isExists[c]) {
//                stack.addFirst(c);
//                map[c]--;
//                isExists[c] = true;
//            }
//
//        }
//        // 此时栈中的元素即为 答案
//        StringBuilder stringBuilder = new StringBuilder();
//        while (!stack.isEmpty()) {
//            stringBuilder.append(stack.pollLast());
//        }
//        return stringBuilder.toString();
//    }

    public static void main(String[] args) {
        Solution_316 sol = new Solution_316();
        System.out.println(sol.removeDuplicateLetters("bbcaac"));
    }
}
