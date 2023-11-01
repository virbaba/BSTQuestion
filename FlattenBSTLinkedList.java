import java.util.* ;
import java.io.*; 
/************************************************************

 Following is the TreeNode class structure
     class TreeNode<T>
     {
         public:
             T data;
             TreeNode<T> left;
             TreeNode<T> right;

            TreeNode(T data)
            {
                this.data = data;
                left = null;
                right = null;
         }
     };
 ************************************************************/
public class Solution
{
    public static TreeNode<Integer> flatten(TreeNode<Integer> root)
    {
        // Write your code here
        // here we use stack for inorder traversal
        if (root == null) return null;

        TreeNode<Integer> dummy = new TreeNode<>(-1);
        TreeNode<Integer> prev = dummy;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            prev.right = current;
            prev = current;
            current = current.right;
            prev.left = null; // Ensure left child is null for the linked list
        }

        return dummy.right;

    }
}
