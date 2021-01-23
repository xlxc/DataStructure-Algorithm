package union_find_set;

import java.util.*;

/**
 * @author: xuejing
 * @date: 2021/01/19 14:25
 * 并查集模板类
 * https://leetcode-cn.com/problems/number-of-provinces/solution/python-duo-tu-xiang-jie-bing-cha-ji-by-m-vjdr/
 */
public class UnionSet {

    /**
     * 每个节点都会记录其父节
     * key：当前节点
     * value：当前节点的父亲节点
     */
    private Map<Integer, Integer> father;

    /**
     * 记录连通分量
     */
    private int size;

    /**
     * 构造函数
     */
    public UnionSet() {
        father = new HashMap<>();
        size = 0;
    }

    /**
     * 向集合中添加一个元素
     */
    public void add(int x) {
        // 在一个节点加入并查集的时候，该节点的父节点是空的，只有两个节点进行 union 合并时才会有父节点
        if (!father.containsKey(x)) {
            father.put(x, null);
            size++;
        }
    }

    /**
     * Find：从集合中查找该节点的祖先，同时需要将整个树打成扁平
     */
    public int find(int x) {
        // 首先找到节点x的祖先节点
        int root = x;
        while (father.get(root) != null) {
            root = father.get(root);
        }
        // 路径压缩:将x路径上的所有节点上的父亲节点都变成 祖先节点，这样下次就可以变成 O(1) 的查找
        while (x != root) {
            int originalFather = father.get(x);
            father.put(x, root);
            x = originalFather;
        }
        return root;
    }

    /**
     * Union：合并两个集合
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        // 只有当两个节点的祖先祖先不相同的时候就将其合并
        if (rootX != rootY) {
            // 将x节点合并到节点y中，只要将x的祖先节点变成y即可
            father.put(rootX, rootY);
            size--;
        }
    }

    /**
     * 查看两个节点是否连通：是否是同一个祖先
     */
    public boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 计算并查集中有多少个不同的连通数
     */
    public int getConnected() {
        return size;
    }
}
