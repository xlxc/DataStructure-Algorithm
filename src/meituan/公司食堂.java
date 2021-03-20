package meituan;

import java.io.*;
import java.util.*;

/**
 * @author: xuejing
 * @date: 2021/03/19 15:00
 */
public class 公司食堂 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        // 每个餐桌的剩余人数
        for (int j = 0; j < t; j++) {
            int n = Integer.parseInt(br.readLine().trim());
            String tables = br.readLine().trim();
            // 人数
            int m = Integer.parseInt(br.readLine());
            String people = br.readLine();
            int[] res = find(tables, people.trim().toCharArray());
            for (int i = 0; i < res.length; i++) {
                bw.write(String.valueOf(res[i]));
                bw.newLine();
            }
            bw.flush();
        }
        br.close();
        bw.close();
    }

    // 如果是 M-男，先找最近的1，没有1，在找最近的0
    // 如果是 F-女，先找最近的0，没有0，在找最近的1
    public static int[] find(String tables, char[] people) {
        int[] table = new int[tables.length()];
        for (int i = 0; i < table.length; i++) {
            table[i] = tables.charAt(i) - '0';
        }
        int tableLen = table.length;
        int peopleLen = people.length;
        // 由于要实现对位置的有序，可以使用三个小根堆，分别代表0,1
        // Java 中默认的就是小根堆
        PriorityQueue<Integer> pq0 = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        // 初始化小根堆中的值，根据table中的0,1,2，分别将对应的需要放入
        for (int i = 0; i < table.length; i++) {
            if (table[i] == 0) {
                pq0.add(i);
            } else if (table[i] == 1) {
                pq1.add(i);
            }
        }
        int[] res = new int[peopleLen];
        for (int i = 0; i < people.length; i++) {
            // seat 表示第 i 个人需要做的位置
            int seat = 0;
            if (people[i] == 'M') {
                // 如果是男士，先从小根堆1中寻找
                if (!pq1.isEmpty()) {
                    seat = pq1.poll();
                } else {
                    seat = pq0.poll();
                    pq1.add(seat);
                }
            } else if (people[i] == 'F') {
                // 如果是女士，先从小根堆0中寻找座位
                if (!pq0.isEmpty()) {
                    seat = pq0.poll();
                    pq1.add(seat);
                } else {
                    seat = pq1.poll();
                }
            }
            res[i] = seat + 1;
        }
        return res;
    }

}
//1
//    5
//    01102
//    6
//    MFMMFF