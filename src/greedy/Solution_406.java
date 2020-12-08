package greedy;

import sun.security.util.PendingException;

/**
 * @author: xuejing
 * @date: 2020/11/29 9:36
 */
public class Solution_406 {

    public static void main(String[] args) {

    }

    public int[][] reconstructQueue(int[][] people) {
        int row = people.length;
        int col = people[0].length;
        int[][] res = new int[row][col];
        if (row == 0 || col == 0) {
            return res;
        }
        // 我们可以先确定 个子最矮的人 所处的位置i
        // 因为最矮的人 前面已经没有比他更矮的了，
        return res;


    }
}








