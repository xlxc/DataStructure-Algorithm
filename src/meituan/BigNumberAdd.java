package meituan;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author: xuejing
 * @date: 2021/01/05 17:01
 *  美团2020校招系统开发方向笔试题
 *  7[编程题]大数加法
 *  输入：
 *  "-26"
 *  "100"
 *  输出：
 *  "74"
 */
public class BigNumberAdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next().replaceAll("\"","");
        String s2 = scanner.next().replaceAll("\"","");
        BigDecimal b1 = new BigDecimal(s1);
        BigDecimal b2 = new BigDecimal(s2);
        System.out.println("\"" + b1.add(b2) + "\"");
        scanner.close();
    }

}
