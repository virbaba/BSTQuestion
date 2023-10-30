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
/* WE USE INORDER TRAVERSAL HERE AND AFTER THE LEFT RETURN WE INCREASE THE VALUE OF I WHICH IS REFERENCE VARIABLE AND WHEN THE VALUE OF I IS EQUALL TO K THEN WE RETURN THE VALUE OF ROOT
*/
public class Solution 
{
    public static int inOrderTraversal(TreeNode<Integer> root, int[] i, int k){
        if(root == null)
            return -1;
        
        int left = inOrderTraversal(root.left, i, k);
        if(left != -1)
            return left;

        i[0]++;

        if(i[0] == k)
            return root.data;
        int right = inOrderTraversal(root.right, i, k);

        if(right != -1)
            return right;

        
        return -1;
    }
	public static int kthSmallest(TreeNode<Integer> root, int k) {
        //    Write your code here.
        int[] i = {0};
        
        return inOrderTraversal(root, i, k);


    }
}

/* using Morris Traversal */
/*
    Time complexity: O(N)
    Space complexity: O(1)
    
    Where 'N' is number of nodes in binary serach tree.
*/



public class Solution {
	private static int morrisTraversal(TreeNode<Integer> root, int k) {
		TreeNode<Integer> curNode = root;

		while (curNode != null) {
			if (curNode.left == null) {
				k = k - 1;

				// If 'curNode' is 'k-th' smallest node
				if (k == 0) {
					return curNode.data;
				}
				curNode = curNode.right;
			} else {
				TreeNode<Integer> prev = curNode.left;

				// Find rightmost child node of 'curNode'
				while (prev.right != null && prev.right != curNode) {
					prev = prev.right;
				}

				// If rightmost node is leaf node then
				// Make a connection between rightmost node and 'curNode'
				if (prev.right == null) {
					prev.right = curNode;
					curNode = curNode.left;
				}

				else {
					prev.right = null;
					k = k - 1;
					if (k == 0) {
						// If 'curNode' is 'k-th' smallest node
						return (curNode.data);
					}
					curNode = curNode.right;
				}
			}
		}

		// If number of nodes less than 'k'
		return -1;
	}

	public static int kthSmallest(TreeNode<Integer> root, int k) {
		// Find 'k-th' smallest node with help of morris traversal
		return morrisTraversal(root, k);
	}
}

