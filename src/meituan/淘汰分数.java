package meituan;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2021/03/19 14:29
 * 美团2021校招笔试-编程题(通用编程试题,第10场)
 */
public class 淘汰分数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        System.out.println(find(x, y, scores));
    }

    public static int find(int x, int y, int[] scores) {
        // 首先给分数进行排序
        Arrays.sort(scores);
        int len = scores.length;
        for (int i = 0; i < scores.length; i++) {
            if ((i + 1) >= x && (i + 1) <= y) {
                int rest = len - i - 1;
                if (rest >= x && rest <= y) {
                    return scores[i];
                }
            }
        }
        return -1;
    }
}

