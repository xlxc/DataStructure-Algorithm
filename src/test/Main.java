package test;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: xuejing
 * @date: 2020/11/25 16:41
 */
public class Main {

    public static void main(String[] args) {
        //        int[] a = {1, 2, 3, 4, 5};
        //        int len = a.length;
        //        int[] left = new int[len];
        //        left[0] = 1;
        //        for (int i = 1; i < a.length; i++) {
        //            left[i] = left[i - 1] * a[i - 1];
        //        }
        //        left[0] = 1;
        //        int[] right = new int[len];
        //        right[len - 1] = 1;
        //        for (int i = a.length - 2; i >= 0; i--) {
        //            right[i] = right[i + 1] * a[i + 1];
        //        }
        //        right[len - 1] = 1;

        //        int[] arr = new int[] {1, 2, 3, 4};
        //        int[] copy = new int[arr.length];
        //        for (int i = 0; i < arr.length; i++) {
        //            copy[i] = arr[i];
        //        }
        //        // 输出复制后的数组内容
        //        System.out.println(Arrays.toString(copy));

        //        int[] arr = new int[] {1, 2, 3};
        //        int[] copy = arr.clone();
        //        System.out.println(Arrays.toString(copy));

//        int[] arr = new int[] {1, 2, 3};
//        int[] copy = new int[arr.length];
//        System.arraycopy(arr, 0, copy, 0, copy.length);
//        System.out.println(Arrays.toString(copy));

        int[] arr = new int[] {1, 2, 3};
        int[] copy = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(copy));

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();


    }
}
