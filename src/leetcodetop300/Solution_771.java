package leetcodetop300;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: xuejing
 * @date: 2020/12/12 11:51
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_771 {


    /**
     * 这道题可以使用 array，hashmap 等
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        // 在 Java 中所有的字符的 ASCII 码值的范围在 0~127 之间
        // 所有我们也可以使用boolean 数组来代替 HashMap
        boolean[] isJ = new boolean[128];
        // 将宝石中对应的字符置为 true
        for (char c : J.toCharArray()) {
            isJ[c] = true;
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (isJ[c]) {
                count++;
            }
        }
        return count;
    }

    // 使用 hashmap
    public int numJewelsInStones1(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c: J.toCharArray()){
            set.add(c);
        }
        int count = 0;
        for (char c : S.toCharArray()){
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }

}











