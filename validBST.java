import java.util.* ;
import java.io.*; 
/*
  here we use BST property which is that when we traverse BST by inorder traversal then all element is sorted in ascending order so we store element and then check it
*/

/*  APPROACH 1 */
public class Solution 
{
	public static void inOrderTraversal(BinaryTreeNode<Integer> root, ArrayList<Integer> list){
		if(root == null)
			return;
		
		inOrderTraversal(root.left, list);
		list.add(root.data);
		inOrderTraversal(root.right, list);
		
	}
	public static boolean validateBST(BinaryTreeNode<Integer> root) 
    {
		// Write your code here.
		ArrayList<Integer> list = new ArrayList<>();
		inOrderTraversal(root, list);
		
		if(list.size() <= 1)
			return true;
		
		
		for(int i = 1; i < list.size(); i++){
			if(list.get(i - 1) >= list.get(i))
				return false;
		}
		return true;
	}
}

/* APPROACH 2 */
/*
    Time Complexity: O(N)
    Space Complexity: O(N)
    
    Where 'N' denotes number of nodes in the binary tree
    if root element is 4 then we know that value of left right most node is always less than to 4 and right left most is always greater then to 4 
*/

public class Solution 
{
    public static boolean helper(BinaryTreeNode<Integer> root, int min, int max) 
   {
    // An empty tree is a BST
    if (root == null) 
    {
        return true;
    }

    // If this node violates the min/max constraint
    if ((root.data <= min) || (root.data >= max)) 
    {
        return false;
    }

    boolean leftSearch = helper(root.left, min, root.data);
    boolean rightSearch = helper(root.right, root.data, max);
    
    return leftSearch & rightSearch;
}

    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
