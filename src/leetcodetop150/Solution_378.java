package leetcodetop150;

import java.util.PriorityQueue;

/**
 * @author: xuejing
 * @date: 2020/12/09 9:38
 * <p>
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * </p>
 */
public class Solution_378 {


//    1 2 3 4 5 6 7 8
//
//        2 3 7 6 8 5 4 1k =5
//
//        8 7 6 3 2

    /**
     * 由于是找第 k 小的元素，第一个想到的应该是使用堆，使用的是大根堆
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        // java 中默认是小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> (y - x));
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(matrix[i][j]);
                } else if (priorityQueue.peek() > matrix[i][j]) {
                    priorityQueue.poll();
                    priorityQueue.add(matrix[i][j]);
                }
            }
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        Solution_378 solution_378 = new Solution_378();
        int[][] matrix = new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(solution_378.kthSmallest(matrix, k));
    }
}
