package leetcodetop500;

import java.util.HashSet;

/**
 * @author: xuejing
 * @date: 2021/03/13 9:02
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
public class Solution_705 {

    private HashSet<Integer> set;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new HashSet<>();
    }

    public void add(int key) {
        set.add(key);
    }

    public void remove(int key) {
        set.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set.contains(key);
    }
}
