package leetcodetop300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xuejing
 * @date: 2020/12/07 12:41
 */
public class Solution_13 {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String str) {
        int result = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();
        // 依次遍历当前的字符串，若当前字符代代表的值小于其右边的值就减去，否则就加上该值
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 > arr.length) {
                continue;
            }
            if (map.get(arr[i]) < map.get(arr[i + 1])) {
                result -= map.get(arr[i]);
            } else {
                result += map.get(arr[i]);
            }
        }
        return result;
    }
}
