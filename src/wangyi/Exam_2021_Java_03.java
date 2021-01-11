package wangyi;

import javafx.concurrent.ScheduledService;

import java.util.Scanner;

/**
 * @author: xuejing
 * @date: 2021/01/10 13:36
 *  网易2021校招笔试-Java开发工程师（正式第二批）
 *  网易严选建有N个自营仓分布在全国各地，标记为仓库1到N。
 * 给定一个配货时间组（v,u,w)，v为出发仓库，u为目标仓库，w为从出发仓库到目标仓库的耗时时间。可能存在仓库间过远，无法支持调拨转货。
 * 指定一个出发仓库K，我们需要将供应商发送到K仓库的货配送到各个仓库。问配送到所有可到达仓库所要最短时间？如果无法全部调拨到，则返回-1.
 */
public class Exam_2021_Java_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
    }
}
