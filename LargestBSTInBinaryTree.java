/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     BinaryTreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
class Result {
    int size;
    int min;
    int max;
    boolean isBST;
    public Result(int size, int min, int max, boolean isBST) {
        this.size = size;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}
public class Solution {
    public static int largestBST(TreeNode root) {
        // Write your code here.
        Result result = findLargestBST(root);
        return result.size;
    }
    public static Result findLargestBST(TreeNode node) {
        if (node == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Result left = findLargestBST(node.left);
        Result right = findLargestBST(node.right);

        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            int size = 1 + left.size + right.size;
            int min = Math.min(node.data, left.min);
            int max = Math.max(node.data, right.max);
            return new Result(size, min, max, true);
        } else {
            return new Result(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }
    }
}
