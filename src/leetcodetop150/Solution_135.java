package leetcodetop150;

import java.util.Arrays;

/**
 * @author: xuejing
 * @date: 2020/12/24 9:38
 */
public class Solution_135 {

    // 按照题目要求，可以知道对于某个位置上
    // 如果优先级比左边的高，那么这个位置上的数就要比左边的数大1，否则这这个位置上的数就是1
    // 对于右边来说，也是这样
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        // 初始值都是1
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        // 遍历左边数组
        for (int i = 1; i < left.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int count = left[left.length - 1];
        // 遍历右边数组
        for (int i = right.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right[i] = right[i+1] +1;
            }
            count += Math.max(left[i],right[i]);
        }
        return count;
    }

    public static void main(String[] args) {

    }

    //      5 4 6 1 2 1 6
    //
    //          2 1 2 1 2 1 2 11
    //
    //          1 1 2 1 2 1 2 10 2 1 2 1 2 1 1 10
    //
    //          2 1 2 1 2 1 2
}
