package wangyi;

import java.util.Scanner;

/**
 * @author: xuejing
 * @date: 2021/01/10 12:02
 * 网易2021校招笔试-Java开发工程师（正式第二批）
 * 已知摩尔斯电码和字符映射关系如下：
 * A -> 0
 * B -> 1
 * C -> 10
 * D -> 11
 * E -> 100
 * F -> 101
 * G -> 110
 * H -> 111
 * 当前我们获取到了一串01数字字符串，需要进行摩尔斯电码解码，请问共有多少种解码方法？
 */
public class Exam_2021_Java_02 {

    // 此题是一种从左向右的尝试模型，
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.nextLine().trim().toCharArray();
        int[] memory = new int[str.length + 1];
        System.out.println(f(str, 0, memory));
    }

    private static int f(char[] str, int index, int[] memory) {
        // base case
        if (memory[index] != 0) {
            return memory[index];
        }
        if (index == str.length) {
            memory[index] = 1;
            return 1;
        }
        if (str[index] == '0') {
            int res = f(str, index + 1, memory);
            memory[index] = res;
            return res;
        }
        int res = f(str, index + 1, memory);
        // i 和 i+1 作为一种组合，后序有多少种
        if (index + 1 < str.length) {
            res += f(str, index + 2, memory);
        }
        // i 和 i+1、i+2 作为一种组合，后序有多少种
        if (index + 2 < str.length) {
            res += f(str, index + 3, memory);
        }
        memory[index] = res;
        return res;
    }

}
