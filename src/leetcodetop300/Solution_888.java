package leetcodetop300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: xuejing
 * @date: 2021/02/01 9:25
 * 888. 公平的糖果棒交换
 */
public class Solution_888 {

    /**
     * 题目的意思是，分别从A和B 两个数组中取出一个数进行交换，使得交换后的两个数组的元素之和相等
     * 分别设交换的数为 x 和 y，则有如下等式：
     * sumA - x + y = sumB - x + y
     * 化简得： x - y = (sumA - sumB) / 2
     * 所以，对于即对于 B 中的任意一个数 y，只要 A 中存在一个数 x，使得等式成立，那么我们就找到了一组可行解
     * 基于此思想，我们可以使用哈希表 或者 排序+双指针 来解决
     *
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        // base case
        if (A == null || B == null) {
            return new int[2];
        }
        return process2(A, B);
    }

    // 使用双指针进行计算
    private int[] process2(int[] a, int[] b) {
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        int delete = (sumA - sumB) / 2;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            int cur = a[i] - b[j];
            if (cur > delete) {
                j++;
            } else if (cur < delete) {
                i++;
            } else {
                return new int[] {a[i], b[j]};
            }
        }
        return new int[2];
    }

    // 使用哈希表解决,为了快速查询 A 中是否存在某个数，我们可以先将 A 中的数字存入哈希表中。
    // 然后遍历 B 序列中的数 y, 在哈希表中查询是否有对应的 x
    private int[] process1(int[] a, int[] b) {
        // 首先分别计算出sumA、sumB
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        int delete = (sumA - sumB) / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        int[] ans = new int[2];
        for (int i = 0; i < b.length; i++) {
            int x = b[i] + delete;
            if (set.contains(x)) {
                ans[0] = x;
                ans[1] = b[i];
                break;
            }
        }
        return ans;
    }

}









