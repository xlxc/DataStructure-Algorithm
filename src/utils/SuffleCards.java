package utils;

import org.omg.DynamicAny._DynUnionStub;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @author: xuejing
 * @date: 2020/12/15 11:01
 * 实现 洗牌算法
 * 洗牌算法的思想可用于 leetcode 384.打乱数组
 */
public class SuffleCards {

    public static void main(String[] args) {
        int[] datas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(Arrays.toString(datas));
        int[] res = shuffle(datas);
        System.out.println("nums:" + res.length);
        System.out.println(Arrays.toString(datas));
        System.out.println(Arrays.toString(res));
        System.out.println("排序后：");
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
    }

    // 洗牌算法实现，使用随机函数每次从数组中取出一个元素放入新数组中，同时将该元素与老数组中的最后一个元素交换
    // 在代码实现上，我们可以从数组的尾部开始遍历，这样就不需要每次记录长度了
    public static int[] shuffle(int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            // 产生随机数,为什么是 i+1 呢？如果不加1，当i=0时就会报错
            int index = random.nextInt(i + 1);
            // 交换元素
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
