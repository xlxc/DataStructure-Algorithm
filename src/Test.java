/**
 * @author: xuejing
 * @date: 2021/01/14 10:43
 */
public class Test {

    public static void main(String[] args) {
        String s = "1234";
        char[] chs = s.toCharArray();
        chs[0] = '9';
        chs[2] = '8';
        System.out.println(new String(chs));
    }
}
