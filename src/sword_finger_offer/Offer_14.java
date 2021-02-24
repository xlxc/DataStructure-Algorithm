package sword_finger_offer;

import javafx.scene.control.MultipleSelectionModel;

/**
 * @author: xuejing
 * @date: 2021/02/23 19:16
 * 剑指 Offer 14- I. 剪绳子
 */
public class Offer_14 {

    // 由于此题没有给出所需划分的个数m，所以一开始最先想到的就是暴力解决
    // 列举出所有的可能组合，然后寻求乘积最大的解
    // 所以可以使用暴力递归来实现
    // 当我们选择需要剪绳子的位置index时，剩下的部分可以继续剪，也可以不剪，由于要求乘积的最大值，所以需要比较到底
    // 是剪还是不剪
    //    i * cuttingRope(n-i):表示继续向下剪绳子
    //    i * (n-i) ;表示不在继续剪绳子
    public int cuttingRope(int n) {
        int[] memo = new int[n + 1];
        memo[2] = 1;
        return process(n, memo);
    }

    private int process(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            // 从index位置开始剪
            // index后面，剩下的不继续剪
            int no = i * (n - i);
            // index 后面，剩下的继续剪
            int yes = i * process(n - i, memo);
            // 然后取最最大
            res = Math.max(res, Math.max(yes, no));
        }
        memo[n] = res;
        return memo[n];
    }
}
