package meituan;

import java.util.Scanner;

/**
 * @author: xuejing
 * @date: 2021/03/19 15:06
 * 小团有一个由N个节点组成的二叉树，每个节点有一个权值。定义二叉树每条边的开销为其两端节点权值的乘积，
 * 二叉树的总开销即每条边的开销之和。小团按照二叉树的中序遍历依次记录下每个节点的权值，即他记录下了N个数，
 * 第i个数表示位于中序遍历第i个位置的节点的权值。之后由于某种原因，小团遗忘了二叉树的具体结构。
 * 在所有可能的二叉树中，总开销最小的二叉树被称为最优二叉树。现在，小团请小美求出最优二叉树的总开销。
 */
public class 最优二叉树2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        // 中序遍历的数组
        // 7 6 5 1 3

    }
}
