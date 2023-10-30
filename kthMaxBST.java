import java.util.* ;
import java.io.*; 
/***********************************************************

	Following is the TreeNode class structure:

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = right = null;
	    }

	};

*************************************************************/
/*
  here we using post order traversal and when return null from right side we increase i value by 1 and if the value of i is equall to k smjo humnea we root hit car diya jo kth max hai
*/
class Solution {

	public static int inOrderTraversal(TreeNode<Integer> root, int[] i, int k){
        if(root == null)
            return -1;
        

		int right = inOrderTraversal(root.right, i, k);	
        if(right != -1)
            return right;

		i[0]++;
        if(i[0] == k)
            return root.data;

		int left = inOrderTraversal(root.left, i, k);
        if(left != -1)
            return left;
        
        return -1;
    }

    public static int KthLargest(TreeNode<Integer> root, int k) {
        // Write your code here.
		int[] i = {0};
        
        return inOrderTraversal(root, i, k);
    }
}
