package meituan;

import javax.xml.bind.UnmarshallerHandler;

/**
 * @author: xuejing
 * @date: 2020/12/25 22:56
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
 * 给定数组A及它的大小n，请返回最大差值。
 * 来源：牛客网
 */
public class MT1_LongestDistance {

    // 由题意可知，对于当前的某个数A[i]，要求前面某个位置上的数使得二者的差值最大
    // 即要是 前面的某个位置上的数越小越好，所以可以遍历一篇数组，用一个变量来记录前面某个数字的最小值即可
    public int getDis(int[] A, int n) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int res = 0;
        int currMin = A[0];
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, A[i] - currMin);
            currMin = Math.min(currMin, A[i]);
        }
        return res;
    }
}
