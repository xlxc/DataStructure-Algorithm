package leetcodetop300;

/**
 * @author: xuejing
 * @date: 2021/03/03 8:53
 * 338. 比特位计数
 */
public class Solution_338 {

    // 由于要达到O(n)的时间复杂度，所有只能扫描一次数组，且每次计算某个数i的二进制中1的个数的时候，要求是O(1)的
    // 故只能由前面的结果来推导出后面的结果了
    // 对于奇数，其二进制中的1的个数，一定比前面的偶数多一个，因为多的就是最低位的1
    // 对于偶数，其二进制中1的个数，和除以2之后的那个数一样多，因为最低位是0，除以2之后就是右移一位，也就是把那个0去掉
    // 所以1的个数是不变的
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}
