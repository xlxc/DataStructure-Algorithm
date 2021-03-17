package leetcodetop500;

import backtracking.Solution_40;

import java.util.Arrays;

/**
 * @author: xuejing
 * @date: 2021/03/17 9:43
 * 1592. 重新排列单词间的空格
 */
public class Solution_1592 {

    // 常规思路：先计算出所有的空格和所有的单词数量，这样就能计算出每个单词之间最大的空格数是多少了
    // 由于使用正则表达式只能计算出所有的单词的个数，并不能计算出所有的字母个数，故不能使用正则表达式
    public String reorderSpaces(String text) {
        // base case
        if (text == null || text.length() == 0) {
            return text;
        }
        int len = text.length();
        text = text.trim();
        String[] words = text.split("\\s+");
        int wordsLength = words.length;
        int letterLen = 0;
        for (int i = 0; i < words.length; i++) {
            letterLen += words[i].trim().length();
        }
        int spaceCount = len - letterLen;
        StringBuilder sb = new StringBuilder();
        if (wordsLength < 2) {
            sb.append(words[0]);
            for (int i = 0; i < len - words[0].length(); i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int maxSpace = spaceCount / (wordsLength - 1);
        int restSpace = spaceCount - maxSpace * (wordsLength - 1);
        String space = "";
        for (int i = 0; i < maxSpace; i++) {
            space += " ";
        }
        for (int i = 0; i < wordsLength - 1; i++) {
            sb.append(words[i]);
            sb.append(space);
        }
        sb.append(words[wordsLength - 1]);
        for (int i = 0; i < restSpace; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_1592 sol = new Solution_1592();
        sol.reorderSpaces(" practice   makes   perfect");
    }
}
