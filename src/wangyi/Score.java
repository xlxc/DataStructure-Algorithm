package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: xuejing
 * @date: 2021/01/27 10:15
 * 网易2021校招笔试-高性能计算工程师（有道）
 * [编程题]小易的考试成绩
 * 小易参加了一次考试，这场包含 n 个题目，第 i 个题目的分数是 si 。
 * 如果小易第 i 题目回答正确，他将得到 Si 分，否则该题目他将得到 0 分。
 * 最终的考试得分是所有题目得分的总和。
 * 由于阅卷老师很讨厌数字 5，在阅卷时如果一个学生的考试总分中含有数字 5，那么阅卷老师将气愤地给他 0 分。
 * 那么小易考试的最高得分是多少？
 */
public class Score {
    /**
     * 其实所有的算法题的思路都是暴力求解法，因为计算机解决问题只能暴力，所谓算法的优化，就是根据不同问题的情况
     * 采用不同的方法对暴力法进行优化，问题的本质爱还是暴力
     * 本题就是求解出所有分数的组合，然后对这个组合进行排序，取出最大的且不包含5的数字即可
     * 先用动规求解背包问题，得到所有能取到的分数，然后再按降序检验分数，第一个不包含5的分数即为所求
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        System.out.println(getMaxScore(scores));
    }

    private static int getMaxScore(int[] scores) {
        Arrays.sort(scores);
        int res = 0;
        for (int i = 0; i < scores.length; i++) {
            res += scores[i];
        }
        if (isHasFive(res)) {
            res -= scores[0];
        }
        return res;
    }

    // 判断一个数字中是否含有5
    private static boolean isHasFive(int number) {
        while (number != 0) {
            if ( number % 10 == 5) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

}
