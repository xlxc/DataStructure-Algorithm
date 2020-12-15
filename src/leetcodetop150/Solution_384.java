package leetcodetop150;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: xuejing
 * @date: 2020/12/15 12:18
 */
public class Solution_384 {

    // 本题可以使用洗牌算法
    private int[] origin;

    public Solution_384(int[] nums) {
        origin = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        // 洗牌算法，核心思想是每次使用随机函数来随机产生数组的下标
        // 然后将该下标中的元素与数组中的最后一个元素交换，依次往复，这样每次都不会取到相同的数了
        // 就算随机产生的下标相同也没关系，因为此时该元素已经被换到了数组的后面了
        Random random = new Random();
        int[] res = Arrays.copyOf(origin, origin.length);
        for (int i = res.length - 1; i >= 0; i--) {
            // 产生随机数
            int index = random.nextInt(i+1);
            int temp = res[index];
            res[index] = res[i];
            res[i] = temp;
        }
        return res;
    }
}
