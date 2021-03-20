package meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: xuejing
 * @date: 2021/03/19 14:54
 */
public class 正则序列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(find(arr));
    }

    public static int find(int[] arr) {
        // 首先给数组进行排序
        Arrays.sort(arr);
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            res += Math.abs((i + 1) - arr[i]);
        }
        return res;
    }
}
