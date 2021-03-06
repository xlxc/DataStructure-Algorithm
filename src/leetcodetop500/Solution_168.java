package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2020/12/12 17:42
 * 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 */
public class Solution_168 {

    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_168 sol = new Solution_168();
        System.out.println(sol.convertToTitle(1));
    }
}
