package youzan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: xuejing
 * @date: 2021/02/03 18:22
 * 有赞2019校招Java笔试（A卷）
 * 字符串旋转:
 * 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
 * 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。
 */
public class RotateString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(";");
        if (strs[0].length() != strs[1].length()) {
            System.out.println(false);
            return;
        }
        boolean res = (strs[0]+strs[0]).contains(strs[1]);
        System.out.println(res);
    }


}
