package nowcoder;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author: xuejing
 * @date: 2021/01/22 9:17
 * 2021届阅文Java方向笔试卷
 * 给定一组自然数，数字的值有可能会大于2^64 ，要求计算出所有数字的和
 */
public class BigSum {
    /**
     * 计算一组数字的和
     *
     * @param numbers string字符串ArrayList 一组自然数
     * @return string字符串
     */
    public String sum(ArrayList<String> numbers) {
        // write code here
        if (numbers == null || numbers.size() == 0) {
            return "";
        }
        BigDecimal bigDecimal = new BigDecimal(0);
        for (String number : numbers) {
            bigDecimal = bigDecimal.add(new BigDecimal(number));
        }
        return String.valueOf(bigDecimal);
    }
}
