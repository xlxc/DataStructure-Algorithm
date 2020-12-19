package tree;

import org.w3c.dom.Node;
import sun.text.resources.cldr.ti.FormatData_ti;
import utils.TreeNode;

import javax.naming.SizeLimitExceededException;
import java.awt.*;
import java.net.HttpRetryException;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: xuejing
 * @date: 2020/12/18 9:56
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_297 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        Solution_297 sol = new Solution_297();
        String res = sol.serialize(t1);
        System.out.println("序列化结果：" + res);
        TreeNode head = sol.deserialize(res);
        System.out.println("反序列化结果：");
        sol.preOrder(head);
    }

    // 所谓的序列化就是将二叉树转换成可存储的字符串，目的是便于存储和网络传输
    // 用什么遍历序列 序列化，就需要用相同的遍历序列来反序列化
    // 我们可以使用 先序遍历 来序列化和反序列化
    // Encodes a tree to a single string.
    // 先序遍历 序列化，使用递归

    private List<String> res;

    public String serialize(TreeNode root) {
        res = new ArrayList<>();
        return serializeByPre(root);
    }

    private String serializeByPre(TreeNode root) {
        if (root == null) {
            res.add("null,");
            return "null,";
        }
        String res = root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;

//        res.add(String.valueOf(root.val));
//        serializeByPre(root.left);
//        serializeByPre(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 预处理，首先将字符串按照 ， 进行分割
        String[] values = data.split(",");
        System.out.println(Arrays.toString(values));
        // 将结果存储在 队列中，便于后序使用
        Queue<String> queue = new LinkedList<>();
        for (String str: values) {
            queue.offer(str);
        }
        return deserializeByPre(queue);
    }

    private TreeNode deserializeByPre(Queue<String> queue) {
        String value = queue.poll();
        // 如果是空节点，那么就直接返回 null
        if ("null".equals(value)) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(value));
        head.left = deserializeByPre(queue);
        head.right = deserializeByPre(queue);
        return head;
    }


    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+",");
        preOrder(root.left);
        preOrder(root.right);
    }
}
