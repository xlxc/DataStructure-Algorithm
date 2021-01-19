package union_find_set;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xuejing
 * @date: 2021/01/19 14:25
 * 并查集模板类
 * https://leetcode-cn.com/problems/number-of-provinces/solution/python-duo-tu-xiang-jie-bing-cha-ji-by-m-vjdr/
 */
public class UnionFindTemplate {

    /**
     * 每个节点都会记录其父节点
     */
    private Map<Integer, Integer> father;

    /**
     * 构造函数
     */
    public UnionFindTemplate() {
        father = new HashMap<>();
    }

    /**
     * 向集合中添加一个元素
     */
    public void add(int x) {
        // 在一个节点加入并查集的时候，该节点的父节点是空的，只有两个节点进行 union 合并时才会有父节点
        if (!father.containsKey(x)) {
            father.put(x, null);
        }
    }

    /**
     * Union：合并两个集合
     */
    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        // 只有当两个节点的祖先祖先不相同的时候就将其合并
        if (rootX != rootY) {
            father.put(rootX, rootY);
        }
    }

    /**
     * Find：从集合中查找该节点的祖先
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
     * 查看两个节点是否连通：是否是同一个祖先
     */
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
