package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xuejing
 * @date: 2020/11/29 9:36
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_406 {

    // 根据题目要求，我们可以先根据身高h进行降序排序，k进行升序排序
    // 排序后会导致身高最高的在最前面，由于k值定义：排在h的前面且身高大于或等于h的人数，
    // 因为身高从降序开始插入的，此时所有人的身高都大于等于h
    // 因此k值就是为需要插入的位置
    public int[][] reconstructQueue(int[][] people) {
        // base case
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        // 按照身高降序，k升序排序
        Arrays.sort(people, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        // 根据k值，调整位置，k值就是需要插入的位置
        List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Solution_406 sol = new Solution_406();
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(sol.reconstructQueue(a)));
    }
}









