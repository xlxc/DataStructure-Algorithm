package across_the_year;

/**
 * @author: xuejing
 * @date: 2020/12/24 9:00
 * 切分木棒
 * 假设要把长度为 n 厘米的木棒切分为 1 厘米长的小段，但是 1 根木棒只能由 1 人切分，
 * 当木棒被切分为 3 段后，可以同时由 3 个人分别切分木棒。
 */
public class CutBar {

    /**
     * @param n 木棒的长度
     * @param m 总的人数
     * @return
     */
    public int cutBar(int n, int m) {
        //
        int slices = 1;
        int cnt = 0;
        while (slices < n) {
            cnt++;
            slices += Math.min(slices, m);
        }
        return cnt;
    }

    public static void main(String[] args) {
        CutBar cutBar = new CutBar();
        System.out.println(cutBar.cutBar(20,3));
        System.out.println(cutBar.cutBar(100,5));
    }
}
