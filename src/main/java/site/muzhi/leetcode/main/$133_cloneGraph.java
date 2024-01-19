package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lichuang
 * @date 2024/01/18
 * 133.克隆图
 */
public class $133_cloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // <源节点,复制后的新节点>
    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        // 当前节点已经处理过，避免重复处理
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 复制节点，并标记当前节点已处理
        Node n = new Node(node.val, new ArrayList<>());
        visited.put(node, n);

        // 递归的方式，补充当前节点的邻居
        for (Node neighbor : node.neighbors) {
            n.neighbors.add(cloneGraph(neighbor));
        }
        return n;
    }
}
