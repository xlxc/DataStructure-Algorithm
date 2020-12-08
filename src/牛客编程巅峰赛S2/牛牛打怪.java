package 牛客编程巅峰赛S2;

import java.util.Arrays;

/**
 * @author: xuejing
 * @date: 2020/11/24 20:06
 *
 * 链接：https://ac.nowcoder.com/acm/contest/9246/A
 * 来源：牛客网
 *
 * 牛牛在各个平台被各种传奇游戏的广告轰炸，所以他决定去玩一玩这类的游戏。这类游戏挂机就可以升级，
 * 所以牛牛每天都能变强。
 * 在第i天里，牛牛能杀死防御力小于等于i的怪物。但由于牛牛还要刷题，所以牛牛每天最多杀一只怪物。
 * 这个游戏共有n只怪物，每只怪物的防御力为DEF[i]，牛牛想知道最少要到第几天才能把这n只怪物都杀死。
 */
public class 牛牛打怪 {

    public static void main(String[] args) {
        int n = 3;
        int[] a = new int[]{3,3,4,5,6,7,7,7,7,8};
        System.out.println(Minimumdays(n,a));
    }

    public static int Minimumdays (int n, int[] def) {
        // write code here
        if (def.length == 0) {
            return 0;
        }
        Arrays.sort(def);
        int res = def[0];
        // 如果和前一个数相等，那么res就加1，如果不相等，那么res就置成当前数的值
        for (int i = 1; i < def.length; i++) {
            if (def[i] == def[i-1]) {
                res++;
            }else if (def[i] > res){
                res = def[i];
            } else {
                res++;
            }
            System.out.println("=="+res);
        }
        return res;
    }
}
