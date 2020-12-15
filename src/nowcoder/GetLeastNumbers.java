package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author: xuejing
 * @date: 2020/12/11 15:52
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 6 5 4 1
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] array = new int[] {4,5,1,6,2,7,3,8};
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        System.out.println(getLeastNumbers.GetLeastNumbers_Solution(array,10).toString());
    }

    // 找出其中最小的 k 个数，这题可以使用 大根堆
    // 当堆顶元素的大小是 k 个数时，如果比堆顶的元素要小，那么就替换堆顶的元素（将大的元素换掉）
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null) {
            return res;
        }
        // Java 中的 PriorityQueue 默认是小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            if (pq.size() < k) {
                pq.add(input[i]);
            } else if (pq.peek() > input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }
        while (pq.size() > 0) {
            res.add(pq.poll());
        }
        return res;
    }
}
