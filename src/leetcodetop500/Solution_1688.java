package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2021/03/17 9:27
 * 1668. 最大重复子字符串
 */
public class Solution_1688 {

    // 暴力解法：先判断连续一个是不是子串，然后判断连续两个是不是子串，依次往下即可
    public int maxRepeating(String sequence, String word) {
        // base case
        if (sequence == null || word == null) {
            return 0;
        }
        String temp = word;
        int count = 0;
        while (sequence.contains(word)) {
            word += temp;
            count++;
        }
        return count;
    }
}
