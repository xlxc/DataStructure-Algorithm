package graph;

/**
 * @author: xuejing
 * @date: 2021/01/11 17:48
 */
public class Solution_997 {

    // 题目规定，成为法官的要求：
    // (1)法官不相信任何人
    // (2)每个人都相信法官

    // 对此，我们可以将其看成是有向图，trust[i]=[a,b]就表示a节点指向b节点的一条边
    // 那么，对于每个节点而言，a的入度表示信任a的人的个数，a的出度表示a信任的人的个数
    // 那么对于法官来说，其入度为n-1，出度为0
    public int findJudge(int N, int[][] trust) {
        if (trust == null || trust.length == 0 || trust[0].length == 0) {
            return 0;
        }
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];
        //由于已经固定了矩阵的列为2，所以只需要一个循环即可
        for (int i = 0; i < trust.length; i++) {
            inDegree[trust[i][1]]++;
            outDegree[trust[i][0]]++;
        }
        // 因为人数是从1开始的
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
