package 前缀和问题;

/**
 * @author: xuejing
 * @date: 2021/01/03 9:54
 */
public class Test {

    public int countSubArray(int[] nums) {
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += 1;
            ans += pre;
        }
        return ans;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {1,3,4};
        System.out.println(test.countSubArray(nums));
    }
}
