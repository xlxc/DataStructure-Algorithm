package wangyi;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2021/01/10 10:17
 * 网易2021校招笔试-Java开发工程师（正式第二批）
 * <p>
 * 疫情逐步缓和后，电影院终于开业了，但是由于当前仍处于疫情期间，应尽量保持人群不聚集的原则。
 * 所以当小易来电影院选定一排后，尽量需要选择一个远离人群的位置。
 * 已知由0和1组成的数组表示当前排的座位情况,其中1表示已被选座，0表示空座
 * 请问小易所选座位和最近人的距离座位数最大是多少？
 * 有如下假设：至少有一个人已选座，至少有一个空座位，且座位数限制为
 */
public class Exam_2021_Java {

    // 根据题意可知，我们需要求出数组中每个0位置上的数，其左边、右边离他最近的1的距离，然后取二者的最小值
    // 所有我们需要计算出数组中每个数的左右最近的1的位置
    // 此题是典型的单调栈
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] seats = scanner.nextLine().trim().split(" ");
        System.out.println(getMaxDistance(seats));
    }

    private static int getMaxDistance(String[] seats) {
        Deque<Integer> zeroStack = new ArrayDeque<>();
        Deque<Integer> oneStack = new ArrayDeque<>();
        Map<Integer, Info> map = new HashMap<>();
        for (int i = 0; i < seats.length; i++) {
            if ("1".equals(seats[i])) {
                oneStack.push(i);
                while (!zeroStack.isEmpty()) {
                    int index = zeroStack.pop();
                    Info info = map.getOrDefault(index, new Info());
                    info.right = i - index;
                    map.put(index, info);
                }
            } else if ("0".equals(seats[i])) {
                zeroStack.push(i);
                if (!oneStack.isEmpty()) {
                    Info info = new Info(i - oneStack.peek(), 0);
                    map.put(i, info);
                }
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Info> item : map.entrySet()) {
            Info info = item.getValue();
            int cur = Math.min(info.left, info.right);
            res = Math.max(res, cur);
        }
        return res;
    }

    static class Info {
        public int left;
        public int right;

        public Info(int left, int right) {
            this.left = left;
            this.right = left;
        }

        public Info() {
            this.left = Integer.MAX_VALUE;
            this.right = Integer.MAX_VALUE;
        }

    }
}
