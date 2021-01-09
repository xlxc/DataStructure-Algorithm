package leetcodetop300;

/**
 * @author: xuejing
 * @date: 2021/01/07 19:24
 */
public class Solution_1160 {

    /**
     * 常规解法：即要统计字母表中字母出现的次数，也要统计单词表中字母出现的次数
     * 如果单词表中每个字母出现的次数都小于等于字母表中出现的次数，那么这个单词就可以被拼出来
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        if (words == null || chars == null) {
            return 0;
        }
        int[] charCounts = count(chars);
        int res = 0;
        for (String word : words) {
            int[] wordCount = count(word);
            if (contains(charCounts,wordCount)) {
                res += word.length();
            }
        }
        return res;
    }

    // 检查字母表中的字母出现次数是否覆盖单词的字母出现次数
    private boolean contains(int[] charCounts, int[] wordCounts) {
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] < wordCounts[i]) {
                return false;
            }
        }
        return true;
    }

    // 统计单词中每个字母出现的次数，由于题目中说都是小写字母，那么我们就可以用26位长的数组来代替哈希表了
    private int[] count(String word) {
        int[] counter = new int[26];
        for (char c : word.toCharArray()) {
            counter[c - 'a']++;
        }
        return counter;
    }
}
