package site.muzhi.leetcode.ds;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author lichuang
 * @date 2020/12/27
 * @description 跳跃链表, 不重复的key值
 * <p>
 * 致谢：
 * 参考博客:https://leetcode-cn.com/circle/article/gRlksy/
 */
public class SkipList<T> {

    static class SkipNode<T> {
        int key;
        T value;

        SkipNode down, right;

        public SkipNode(int key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 头结点
     */
    private SkipNode head;
    /**
     * 当前跳表索引层数
     */
    private int heightLevel;
    /**
     * 跳表索引最高层数
     */
    private final int MAX_LEVEL = 32;
    /**
     * 用于投掷硬币
     */
    private Random random;

    public SkipList() {
        head = new SkipNode<T>(Integer.MIN_VALUE, null);
        heightLevel = 0;
        random = new Random();
    }


    /**
     * 寻找节点
     *
     * @param key
     * @return
     */
    public SkipNode<T> get(int key) {
        SkipNode team = head;
        while (team != null) {
            if (team.key == key) {
                return team;
            } else if (team.right == null) {
                // 右侧没有索引,则向下寻找
                team = team.down;
            } else if (team.right.key > key) {
                // 右侧的索引高于指定的索引,则向下寻找
                team = team.down;
            } else {
                // 右侧的索引小于指定的索引寻找
                team = team.right;
            }
        }
        return null;
    }

    /**
     * 更新节点的值
     *
     * @param key
     * @param newVal
     * @return
     */
    public void update(int key, T newVal) {
        SkipNode team = head;
        while (team != null) {
            if (team.key == key) {
                // 更新值
                team.value = newVal;
                team = team.down;
            } else if (team.right == null) {
                // 向下寻找
                team = team.down;
            } else if (team.right.key > key) {
                // 向下寻找
                team = team.down;
            } else {
                team = team.right;
            }
        }
    }

    /**
     * 删除节点
     *
     * @param key
     * @return
     */
    public void delete(int key) {
        // team指向要移除节点的前驱节点
        SkipNode team = head;
        while (team != null) {
            if (team.right == null) {
                team = team.down;
            } else if (team.right.key == key) {
                // 移除节点,并向下继续寻找
                team.right = team.right.right;
                team = team.down;
            } else if (team.right.key > key) {
                // 向下寻找
                team = team.down;
            } else {
                // 向右寻找
                team = team.right;
            }
        }
        // 重新计算层高
        while (head.right == null) {
            head = head.down;
            heightLevel--;
        }
    }

    /**
     * 新增节点
     *
     * @param newNode
     */
    public void add(SkipNode<T> newNode) {
        int key = newNode.key;
        SkipNode<T> node = get(key);
        // 存在此key的节点，默认更新值
        if (node != null) {
            node.value = newNode.value;
            return;
        }
        // 存储向下的节点，这些节点的右侧可能会插入节点
        LinkedList<SkipNode> stack = new LinkedList<>();
        SkipNode team = head;
        // 寻找要插入的节点的位置，并且记录索引层中可能右侧需要添加新节点的路径
        while (team != null) {
            if (team.right == null) {
                // 右侧为空，向下寻找
                stack.addLast(team);
                team = team.down;
            } else if (team.right.key > key) {
                // 右侧的key大于新节点的key，向下寻找
                stack.addLast(team);
                team = team.down;
            } else {
                // 向右
                team = team.right;
            }
        }
        // 当前层为第一层
        int level = 1;
        // 指向当前层节点的下一层同一列的节点
        SkipNode downNode = null;
        while (!stack.isEmpty()) {
            // 当前层插入节点
            // 弹出节点
            team = stack.pollLast();
            // 重建节点
            SkipNode<T> teamNode = new SkipNode<>(newNode.key, newNode.value);
            // 处理列方向
            teamNode.down = downNode;
            downNode = teamNode;
            // 右侧为空，表示插入尾节点
            if (team.right == null) {
                team.right = teamNode;
            }

            // 处理行方向
            if (level > MAX_LEVEL) {
                // 已经达到最高层
                break;
            }
            // [0,1]之中的随机数
            if (random.nextDouble() > 0.5) {
                // 1/2概率进行向上层建立索引
                break;
            }
            level++;
            // 新增的层数超过原来的层数,需要改变head节点
            if (level > heightLevel) {
                heightLevel = level;
                SkipNode<T> highHeadNode = new SkipNode<>(Integer.MIN_VALUE, null);
                highHeadNode.down = head;
                head = highHeadNode;
                // 下次抛出新的head节点,并且在新的head头结点后添加新的索引层节点
                stack.addLast(head);
            }
        }
    }

    public void print() {
        SkipNode teamHead = head;
        int level = heightLevel;
        SkipNode lastNode = teamHead;
        while (lastNode.down != null) {
            lastNode = lastNode.down;
        }
        while (teamHead != null) {
            SkipNode enumNode = teamHead.right;
            SkipNode enumLast = lastNode.right;
            System.out.printf("Lv(%d)%-8s", level--, "head->");
            while (enumLast != null && enumNode != null) {
                if (enumLast.key == enumNode.key) {
                    System.out.printf("%-6s", enumNode.key + "(" + enumNode.value + ")" + "->");
                    enumNode = enumNode.right;
                    enumLast = enumLast.right;
                } else {
                    enumLast = enumLast.right;
                    System.out.printf("%-6s", "");
                }
            }
            teamHead = teamHead.down;
            //level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList<Integer> list = new SkipList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(new SkipNode(i, i));
        }
        System.out.println("--基本数据");
        list.print();

        System.out.println("--更新之后");
        list.update(5, 0);
        list.print();

        System.out.println("--删除后");
        list.delete(2);
        list.delete(4);
        list.delete(6);
        list.delete(8);
        list.print();
    }
}

