package Week7;

/**
 * Node class for the binary tree.
 *
 * */
public class BTNode<T> {
    protected T data;
    protected BTNode<T> left;
    protected BTNode<T> right;

    public BTNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }


    public StringBuilder treeToString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        // 1. 添加当前节点
        sb.append(prefix)
                .append(isTail ? "└── " : "├── ")
                .append(data)
                .append("\n");

        // 2. 生成子节点的前缀（缩进和连接线）
        StringBuilder childPrefix = new StringBuilder(prefix);
        childPrefix.append(isTail ? "    " : "│   ");

        // 3. 先递归右子树（显示在上方），再递归左子树（显示在下方）
        if (right != null || left != null) {
            if (right != null) {
                // 右子树非空，继续递归
                right.treeToString(new StringBuilder(childPrefix).append("├── "), false, sb);
            } else {
                // 右子树为空，显式标记 null
                sb.append(childPrefix).append("├── null\n");
            }

            if (left != null) {
                // 左子树非空，继续递归
                left.treeToString(new StringBuilder(childPrefix).append("└── "), true, sb);
            } else {
                // 左子树为空，显式标记 null
                sb.append(childPrefix).append("└── null\n");
            }
        }
        return sb;
    }
}
