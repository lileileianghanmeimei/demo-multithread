package arithmetic;

/**
 * 二叉树结点定义
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
