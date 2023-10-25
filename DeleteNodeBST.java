/*

    Time Complexity : O(N)
    Space Complexity : O(N)

    where N is the number of nodes in the BST.

*/

public class Solution {
    public static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }

        else if (key > root.data) {
            root.right = deleteNode(root.right, key);   
        }

        else {

            // Leaf node.
            if (root.left == null && root.right == null) {
                return null;
            }

            // Node doesn't have a left subtree.
            if (root.left == null) {
                return root.right;
            }


            // Node doesn't have a right subtree.
            if (root.right == null) {
                return root.left;
            }


            // Find the minimum value in the right Subtree(predecessor).
            BinaryTreeNode<Integer> leftSubtree = root.left;

            while (leftSubtree.right != null) {
                leftSubtree = leftSubtree.right;
            }

            root.data = leftSubtree.data;

            // Delete the inorder predecessor.
            root.left = deleteNode(root.left, leftSubtree.data);
        }

        return root;
    }
}
