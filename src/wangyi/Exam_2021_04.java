package wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: xuejing
 * @date: 2021/01/06 10:43
 * 小易今天读了一篇英语文章，他现在想从里面找出一个单词作为这篇文章的关键词，一个单词可以作为关键词当且仅当它在这篇文章中出现的频率不低于 1% ，现在他想知道有多少个不同的单词可以作为关键词。
 */
public class Exam_2021_04 {
    // 0.01
    // 只要概率大于 0.01 就可以了
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        int res = 0;
        double freq = 0.01;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(strs[i], map.getOrDefault(strs[i], 0) + 1);
        }
        for (Map.Entry item : map.entrySet()) {
            int count = (Integer)item.getValue();
            Double c = count*1.00 / n * 1.00;
//            System.out.println(item.getKey() + ":" + count + "--" + c);
            if (c >= 0.01) {
                res++;
            }
        }
        System.out.println(res);
    }
}
