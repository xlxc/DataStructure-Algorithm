package 牛客编程巅峰赛S2;


/**
 * @author: xuejing
 * @date: 2020/11/24 20:21
 *
 *  首先公式推导，然后使用快速幂进行加速
 *
 * 链接：https://ac.nowcoder.com/acm/contest/9246/B
 * 来源：牛客网
 *
 * 现在有3个数组a，b，c
 *
 * a[1]=2,a[2]=6,对所有的n>=3,a[n] = 2*a[n-1] + 3*a[n-2]。
 *
 * b[1]=7,b[2]=35,对所有的n>=3,b[n] = 3*b[n-1] + 10*b[n-2]。
 *
 * 对所有的n>=1,有c[n] = a[n]*b[n]。
 *
 * 现在给你一个正整数n,返回c[n]%1000000007的值。
 */
public class 简答的公式 {

    private final static int CNST = 1000000007;

    public static void main(String[] args) {
        System.out.println(Answerforcn(10));
    }

    public static int Answerforcn (long n) {
        // write code here
        return (int)((calculateAn(n) * calculateBn(n)) % CNST);
    }

    private static long calculateAn(long n){
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 6;
        }
        long a1 = 2;
        long a2 = 6;
        long res = 0;
        for (int i = 3; i <= n; i++) {
            res = 2*a2 + 3*a1;
            a1 = a2;
            a2 = res;
        }
        return res%1000000007;
    }

    private static long calculateBn(long n){
        if (n == 1) {
            return 7;
        }
        if (n == 2) {
            return 35;
        }
        long b1 = 7;
        long b2 = 35;
        long res = 0;
        for (int i = 3; i <= n; i++) {
            res = 3*b2 + 10*b1;
            b1 = b2;
            b2 = res;
        }
        return res%1000000007;
    }
}
