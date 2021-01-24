package weeklyCompetition;

/**
 * @author: xuejing
 * @date: 2021/01/24 10:07
 * 5661. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 */
public class Test1 {

    public String maximumTime(String time) {
        if (time == null || time.length() == 0) {
            return "";
        }
        String[] times = time.split(":");
        StringBuilder sb = new StringBuilder();
        // 解决第一位：小时，从 00 - 23
        // 如果第一位是 ？
        char first = times[0].charAt(0);
        char second = times[0].charAt(1);
        if (first == '?' && second != '?') {
            first = second <= '3' ? '2' : '1';
        }
        if (first != '?' && second == '?') {
            second = first <= '1' ? '9' : '3';
        }
        if (first == '?' && second == '?') {
            first = '2';
            second = '3';
        }
        sb.append(first).append(second).append(":");
        // 解决第二位：分钟，从 00 - 59
        first = times[1].charAt(0);
        second = times[1].charAt(1);
        if (first == '?' && second != '?') {
            first = '5';
        }
        if (first != '?' && second == '?') {
            second = '9';
        }
        if (first == '?' && second == '?') {
            first = '5';
            second = '9';
        }
        sb.append(first).append(second);
        return sb.toString();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.maximumTime("2?:?0"));
    }

}
