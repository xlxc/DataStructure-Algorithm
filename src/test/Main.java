package test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: xuejing
 * @date: 2020/11/25 16:41
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int len = a.length;
        int[] left = new int[len];
        left[0] = 1;
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        left[0] = 1;
        int[] right = new int[len];
        right[len - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        right[len - 1] = 1;
    }
}
