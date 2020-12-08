package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xuejing
 * @date: 2020/11/28 17:57
 */
public class Solution_17 {

    private static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    public static void main(String[] args) {
        Solution_17 solution_17 = new Solution_17();
        System.out.println(solution_17.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits,0,"",res);
        return res;
    }

    private void dfs(String digits, int index, String path, List<String> res) {
        if (index == digits.length()) {
            res.add(path);
            return;
        }
        // 提取出 index 位置的字符
        char key = digits.charAt(index);
        String value = map.get(key);
        for (int i = 0; i < value.length(); i++) {
            // 注意，当 paht 为 String 的时候就无需回溯
            // 因为 String 拼接字符串的时候每次都会创建一个新的字符串，故递归后无需撤销操作
            dfs(digits,index+1,path+value.charAt(i),res);
        }
    }



}
