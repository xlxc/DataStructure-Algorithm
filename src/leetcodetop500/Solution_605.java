package leetcodetop500;

/**
 * @author: xuejing
 * @date: 2021/01/01 10:40
 * 605. 种花问题
 */
public class Solution_605 {

    // 根据题意，我们知道，当某处种了花后，那么它的左右两侧就不能在种花了，说明遇到了连续的3个0，就可以种一朵花
    // 利用这个思想，我们可以来解决
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // base case
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        // 为了便于判断，我们需要在数组的头尾两端加上一个0
        int[] dummy = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, dummy, 1, flowerbed.length);
        for (int i = 1; i < dummy.length-1; i++) {
            if (dummy[i-1] == 0 && dummy[i] == 0 && dummy[i+1] == 0) {
                dummy[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
