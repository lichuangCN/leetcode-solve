package site.muzhi.tree;

/**
 * @author: LiChuang
 * @date: 2020/02/29
 * @description: 序列化是将数据结构或对象转换为一系列位的过程，
 * 以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 */
public class $449_SerializeAndDeserializeBst {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Codec {

        /**
         * Encodes a tree to a single string.
         *
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            doSerialize(root, sb);
            String result = sb.toString();
            // 移除最后一位分隔符
            return result.substring(0, result.length() - 1);
        }

        /**
         * 先序遍历二叉树
         *
         * @param root
         * @param sb
         */
        private void doSerialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val + ",");
            doSerialize(root.left, sb);
            doSerialize(root.right, sb);
        }

        /**
         * Decodes your encoded data to tree.
         *
         * @param data
         * @return
         */
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] values = data.split(",");
            return doDeserialize(values, 0, values.length - 1);
        }

        /**
         * @param data 节点数值的字符数组
         * @param low
         * @param high
         * @return
         */
        private TreeNode doDeserialize(String[] data, int low, int high) {
            if (low > high) {
                return null;
            }
            // 构建当前节点
            TreeNode node = new TreeNode(Integer.parseInt(data[low]));
            // 寻找大于当前节点的第一个元素的位置
            int index = high + 1;
            for (int i = low + 1; i <= high; i++) {
                if (Integer.parseInt(data[i]) > node.val) {
                    index = i;
                    break;
                }
            }
            // 构建当前节点的左子树
            node.left = doDeserialize(data, low + 1, index - 1);
            // 构建当前节点的右子树
            node.right = doDeserialize(data, index, high);
            return node;
        }
    }
}
