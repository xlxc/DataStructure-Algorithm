package nowcoder;

import java.math.BigDecimal;

/**
 * @author: xuejing
 * @date: 2021/01/27 9:35
 */
public class BigNumAdd {

    public String solve (String s, String t) {
        if (s == null || t == null) {
            return s == null ? t : s;
        }
        BigDecimal bigs = new BigDecimal(s);
        BigDecimal bigt = new BigDecimal(t);
        bigs = bigs.add(bigt);
        return String.valueOf(bigs);
    }
}
